package cfg.codeforgood.service;

import cfg.codeforgood.entity.Survey;
import cfg.codeforgood.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyServiceItf {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }
}

