package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    static HashMap<String,String> actionChoices = new HashMap<>();
    static HashMap<String, String> columnChoices = new HashMap<>();
    static HashMap<String, Object> tableChoices = new HashMap<>();

    public TechJobsController() {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");

        tableChoices.put("all","View All");
        tableChoices.put("employer", JobData.getAllEmployers());
        tableChoices.put("location", JobData.getAllLocations());
        tableChoices.put("positionType", JobData.getAllPositionTypes());
        tableChoices.put("coreCompetency", JobData.getAllCoreCompetency());


    }
    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoice(Model model) {
        model.addAttribute("actionsTitle","View jobs by:");
        return actionChoices;

    }

    @ModelAttribute("columns")

    public static HashMap<String, String> getColumnChoices(Model model) {
        model.addAttribute("columnsTitle","View jobs By Category");

        return columnChoices;
    }
    @ModelAttribute("tables")
    public static HashMap<String, Object> getTableChoices(Model model) {

        return tableChoices;
    }
}
