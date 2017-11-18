package cfg.codeforgood.controller;

import cfg.codeforgood.entity.AgeGroup;
import cfg.codeforgood.entity.Indicator;
import cfg.codeforgood.entity.Survey;
import cfg.codeforgood.service.IndicatorServiceImpl;
import cfg.codeforgood.service.SurveyServiceImpl;
import javafx.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/indicator")
public class IndicatorController {

    private IndicatorServiceImpl indicatorService;
    private SurveyServiceImpl surveyService;

    public IndicatorController(IndicatorServiceImpl indicatorService, SurveyServiceImpl surveyService) {
        this.indicatorService = indicatorService;
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/show",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public List<Indicator> getAllIndicators() {
        return indicatorService.getAll();
    }

    @RequestMapping(value = "/distinctCat",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseBody
    public List<String> getDistinctCat() {
        return indicatorService.getDistinctCategories();
    }


    @RequestMapping(value = "/magicGet",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<String, Map<String, Float>>> magicMethod(@RequestParam(value = "country") String country,
                                    @RequestParam(value = "category") String category) {
        List<Survey> surveys = new ArrayList<>();
        List<Pair<String, Map<String, Float>>> myReturnList = new ArrayList<>();
        List<String> countries = new ArrayList<>();
        List<Indicator> indicators = indicatorService.getByType(category);
        for (Indicator i : indicators) {
            String indName = i.getName();
            surveys.clear();
            Map<String, Float> hmap = new HashMap<>();
            for(Survey s : i.getSurveys()) {
                if (s.getCountry().equals(country)) {
                    surveys.add(s);

                    for (AgeGroup ag : s.getAgegroups()) {
                        if (ag.getAgerange().charAt(0) == '1')
                            hmap.put(new String("15-19"), ag.getValue());
                        else if (ag.getAgerange().charAt(0) == '2')
                            hmap.put(new String("20-29"), ag.getValue());
                        else if (ag.getAgerange().charAt(0) == '3')
                            hmap.put(new String("30-39"), ag.getValue());
                        else if (ag.getAgerange().charAt(0) == '4')
                            hmap.put(new String("40-49"), ag.getValue());
                        else
                            hmap.put(new String("Total"), ag.getValue());

                    }
                }
            }
            Pair<String, Map<String, Float>> p = new Pair<>(indName, hmap);
            myReturnList.add(p);
        }


        return myReturnList;
    }
}
