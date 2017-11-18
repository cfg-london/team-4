package cfg.codeforgood.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


class Pair<L,R> {
    private L l;
    private R r;

    public Pair(){}

    public Pair(L l, R r) {
        this.l = l;
        this.r = r;
    }

    public void setFirst(L l) {
        this.l = l;
    }

    public void setSecond(R r) {
        this.r = r;
    }

    public L getFirst() {
        return l;
    }

    public R getSecond() {
        return r;
    }
}

public class SurveyAndAgeGroupParser {
    public SurveyAndAgeGroupParser(HashMap<String, Integer> hmIndicator) {
        this.hmIndicator = hmIndicator;
        try {
            this.br = new BufferedReader(new FileReader("src/main/extras/survey_age.csv"));
            this.bw = new BufferedWriter(new FileWriter("src/main/resources/data.sql", true));
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public SurveyAndAgeGroupParser(){
        hmIndicator = new HashMap<>();
        try {
            this.br = new BufferedReader(new FileReader("src/main/extras/survey_age.csv"));
            this.bw = new BufferedWriter(new FileWriter("src/main/resources/data.sql", true));
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public SurveyAndAgeGroupParser(String inFile, String outFile, HashMap<String, Integer> hmIndicator) {
        this.hmIndicator = hmIndicator;

        try {
            this.br = new BufferedReader(new FileReader(inFile));
            this.bw = new BufferedWriter(new FileWriter(outFile, true));
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public void parseFirstLine(ArrayList<Pair<String, ArrayList<String>>> nameDelims) throws IOException{
        //Initial info from first line
        StringTokenizer st = new StringTokenizer(br.readLine(), ",", true);
        st.nextToken();
        st.nextToken();
        st.nextToken();
        String name = st.nextToken();
        do {
            String delim = "";
            ArrayList<String> categs = new ArrayList<>();
            while(st.hasMoreTokens() && (delim = st.nextToken()).equals(",")) {
                categs.add("");
            }

            nameDelims.add(new Pair<>(name, categs));
            name = delim;
        } while (st.hasMoreTokens());
    }

    void parse() {
        ArrayList<Pair<String, ArrayList<String>>> nameDelims = new ArrayList<>();
        try {
            parseFirstLine(nameDelims);
            StringTokenizer st;
            String line, name;
            //Actual categories
            st = new StringTokenizer(br.readLine(), ",");
            st.nextToken();
            st.nextToken();

            for (int i = 0; i < nameDelims.size(); i++) {
                for(int j = 0; j < nameDelims.get(i).getSecond().size(); j++) {
                    nameDelims.get(i).getSecond().set(j, st.nextToken());
                }
            }

            int survey_counter = 1;
            int agegr_counter = 1;
            while((line = br.readLine()) != null) {
                st = new StringTokenizer(line, ",", true);
                String country = st.nextToken();
                st.nextToken();
                StringTokenizer toks = new StringTokenizer(st.nextToken(), " ");
                String year = toks.nextToken();
                String company = toks.nextToken();

                for (Pair<String, ArrayList<String>> p : nameDelims) {
                    name = p.getFirst();
                    int id = hmIndicator.get(name);

                    String query = SurveyDBConstants.INSERT;
                    query += "\'" + survey_counter + "\', ";
                    query += "\'" + company + "\', ";
                    query += "\'" + year + "\', ";
                    query += "\'" + country + "\', ";
                    query += "\'" + id + "\');\n";

                    bw.append(query);

                    for (int i = 0; i < p.getSecond().size(); i++) {
                        query = AgeGroupDBConstants.INSERT;
                        query += "\'" + agegr_counter + "\', ";
                        agegr_counter++;

                        query += "\'" + p.getSecond().get(i) + "\', ";
                        st.nextToken();
                        String value = st.nextToken();

                        query += "\'" + value + "\', ";
                        query += "\'" + survey_counter + "\');\n";

                        bw.append(query);
                    }

                    survey_counter++;
                }
            }
            bw.close();
            br.close();
        }
        catch (Exception e) {e.printStackTrace();}
    }

    private HashMap<String, Integer> hmIndicator;
    private BufferedReader br;
    private BufferedWriter bw;
}
