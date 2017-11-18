package cfg.codeforgood.utils;

import java.util.HashMap;

interface IndicatorDBConstants {
    String INSERT = "INSERT INTO `codeforgood`.`indicator` (`id`, `description`, `name`, `type`) VALUES (";
}

interface SurveyDBConstants {
    String INSERT = "INSERT INTO `codeforgood`.`survey` (`id`, `company`, `year`, `country`, `indicator_id_fk`) VALUES (";
}

interface AgeGroupDBConstants {
    String INSERT = "INSERT INTO `codeforgood`.`agegroup` (`id`, `agerange`, `val`, `survey_id_fk`) VALUES (";
}

public class DBParser {
    public static void doWork() {
        IndicatorParser ip = new IndicatorParser();
        HashMap<String, Integer> ret = ip.parse();
        SurveyAndAgeGroupParser sap = new SurveyAndAgeGroupParser(ret);
        sap.parse();
    }
}
