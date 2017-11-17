package cfg.codeforgood.controller;

import cfg.codeforgood.entity.Indicator;
import cfg.codeforgood.service.IndicatorServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/indicator")
public class IndicatorController {

    private IndicatorServiceImpl indicatorService;

    public IndicatorController(IndicatorServiceImpl indicatorService) {
        this.indicatorService = indicatorService;
    }

    @RequestMapping(value = "/show",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public List<Indicator> getAllIndicators() {
        return indicatorService.getAll();
    }
}
