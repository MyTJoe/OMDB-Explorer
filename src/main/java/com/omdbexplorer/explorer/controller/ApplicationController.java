package com.omdbexplorer.explorer.controller;


import com.omdbexplorer.explorer.client.Client;
import com.omdbexplorer.explorer.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ApplicationController {
    @CrossOrigin
    @ResponseBody
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Movie> movieInfo() {
        List<Movie> results = new Client().getData();
        return results;

    }
}
