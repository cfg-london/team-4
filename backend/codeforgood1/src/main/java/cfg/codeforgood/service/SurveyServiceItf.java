package cfg.codeforgood.service;

import cfg.codeforgood.entity.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurveyServiceItf {
    List<Survey> getAll();

    List<String> findDistinctCountries();
}
