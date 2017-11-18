package cfg.codeforgood;

import cfg.codeforgood.utils.IndicatorParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeforgoodApplication {

	public static void main(String[] args) {
		IndicatorParser ip = new IndicatorParser();
		ip.parse();
		SpringApplication.run(CodeforgoodApplication.class, args);
	}
}
