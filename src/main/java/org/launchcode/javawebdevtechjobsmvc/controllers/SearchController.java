package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;
import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.tableChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @RequestMapping(value = "results")
    public String listJobsByValue(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<Job> jobs;

         if (searchType.toLowerCase().equals("all")) {
             jobs = JobData.findByValue(searchTerm);
           model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ":" + searchTerm);
        } else {
         jobs = JobData.findByColumnAndValue(searchType, searchTerm);
          }
          model.addAttribute("jobs", jobs);
          model.addAttribute("columns", columnChoices);


        //System.out.println(jobs);
          return "search";

    }

}
