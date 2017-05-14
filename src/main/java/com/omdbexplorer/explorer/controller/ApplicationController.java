package com.omdbexplorer.explorer.controller;


import com.omdbexplorer.explorer.client.Client;
import com.omdbexplorer.explorer.data.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<Movie> movieInfo() {
        List<Movie> results = new Client().getData();
        return results;
    }
}
