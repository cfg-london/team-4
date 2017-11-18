package cfg.codeforgood.controller;

import cfg.codeforgood.entity.Survey;
import cfg.codeforgood.service.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

    private SurveyServiceImpl surveyService;

    @Autowired
    public SurveyController(SurveyServiceImpl surveyService) {
        this.surveyService = surveyService;
    }

    @ResponseBody
    @RequestMapping(value = "/show",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<Survey> getAllSurveys() {
        return surveyService.getAll();
    }

    @RequestMapping(value = "/distinctCountries",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseBody
    public List<String> getDistinctCountries() {
        return surveyService.findDistinctCountries();
    }
}
