package cfg.codeforgood;

import cfg.codeforgood.utils.IndicatorParser;
import cfg.codeforgood.utils.SurveyAndAgeGroupParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CodeforgoodApplication {

	public static void main(String[] args) {
		IndicatorParser ip = new IndicatorParser();
		HashMap<String, Integer> ret = ip.parse();
		SurveyAndAgeGroupParser sap = new SurveyAndAgeGroupParser(ret);
		sap.parse();

		SpringApplication.run(CodeforgoodApplication.class, args);
	}
}
