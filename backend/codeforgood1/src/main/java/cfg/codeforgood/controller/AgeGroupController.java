package cfg.codeforgood.controller;


import cfg.codeforgood.entity.AgeGroup;
import cfg.codeforgood.service.AgeGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/agegroup")
public class AgeGroupController {
    private AgeGroupServiceImpl ageGroupService;

    @Autowired
    public AgeGroupController(AgeGroupServiceImpl ageGroupService) {
        this.ageGroupService = ageGroupService;
    }

    @RequestMapping(value = "/show",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseBody
    public List<AgeGroup> getAllAgeGroups() {
        return ageGroupService.getAll();
    }

}
