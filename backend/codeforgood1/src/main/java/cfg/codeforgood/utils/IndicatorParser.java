package cfg.codeforgood.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class IndicatorParser {
    private BufferedReader br;
    private BufferedWriter bw;

    public IndicatorParser() {
        try {
            br = new BufferedReader(new FileReader("src/main/extras/indicators.tsv"));
            bw = new BufferedWriter(new FileWriter("src/main/resources/data.sql"));
        }
        catch (Exception e) { e.printStackTrace();}
    }

    public HashMap<String, Integer> parse() {

        HashMap<String, Integer> hmIndicator = new HashMap<>();
        try {
            String line;

            int counter = 1;

            while((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                String name = st.nextToken();
                String description = st.nextToken();
                String type = st.nextToken();

                hmIndicator.put(name, counter);

                String myquery = IndicatorDBConstants.INSERT;
                myquery += "\'" + counter + "\', ";
                myquery += "\'" + description + "\', ";
                myquery += "\'" + name + "\', ";
                myquery += "\'" + type + "\');\n";

                bw.append(myquery);
                counter++;
            }

            br.close();
            bw.close();
        }
        catch (Exception e) {e.printStackTrace();}

        return hmIndicator;
    }
}

