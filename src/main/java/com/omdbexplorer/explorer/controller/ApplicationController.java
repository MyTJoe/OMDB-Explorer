package com.omdbexplorer.explorer.controller;

import com.omdbexplorer.explorer.client.Client;
import com.omdbexplorer.explorer.data.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ApplicationController {

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ModelAndView movie(String keyword) {
        ModelAndView view = new ModelAndView("index");
        if (keyword.length() == 0){
            return view.addObject("error", "Please enter a title");
        }
        List<Movie> results = new Client().getData(keyword);
        if (results.size() == 0) {
            view.addObject("error", "Sorry  there were no results for: "
                    + keyword + ", please try again.");
        } else{
            view.addObject("results", results);
        }
        return view;
    }
}
