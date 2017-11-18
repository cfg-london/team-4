package cfg.codeforgood.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

interface IndicatorDBConstants {
    String INSERT = "INSERT INTO `codeforgood`.`indicator` (`id`, `description`, `name`, `type`) VALUES (";
}

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

    public void parse() {
        try {
            if (!br.ready()) {
                return;
            }



            String line;

            int counter = 1;

            while((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                String name = st.nextToken();
                String description = st.nextToken();

                String myquery = IndicatorDBConstants.INSERT;
                myquery += "\'" + counter + "\', ";
                myquery += "\'" + description + "\', ";
                myquery += "\'" + name + "\', ";

                String type;
                if (description.contains("Percentage")) {
                    type = "percentage";
                }
                else {
                    type = "ratio";
                }
                myquery += "\'" + type + "\');\n";

                bw.append(myquery);
                counter++;
            }

            br.close();
            bw.close();
        }
        catch (Exception e) {e.printStackTrace();}
    }
}

