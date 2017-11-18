package cfg.codeforgood;

import cfg.codeforgood.utils.DBParser;
import cfg.codeforgood.utils.IndicatorParser;
import cfg.codeforgood.utils.SurveyAndAgeGroupParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CodeforgoodApplication {

	public static void main(String[] args) {
		DBParser.doWork();
		SpringApplication.run(CodeforgoodApplication.class, args);
	}
}
