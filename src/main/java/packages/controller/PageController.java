package packages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import packages.service.ServiceProject;
import packages.service.ServiceProjectImpl;

@Controller
public class PageController {
    @Autowired
    private ServiceProject serviceProject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        return "index";
    }

    @RequestMapping(value = "/richest", method = RequestMethod.GET)
    public String getRichest(ModelMap modelMap) {
        modelMap.put("richest", serviceProject.getRichestUser());
        return "index";
    }

    @RequestMapping(value = "/sumAccounts", method = RequestMethod.GET)
    public String getResources(ModelMap modelMap) {
        modelMap.put("accounts", serviceProject.getSumAccounts());
        return "index";
    }
}
