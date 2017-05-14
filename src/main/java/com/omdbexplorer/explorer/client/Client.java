package com.omdbexplorer.explorer.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omdbexplorer.explorer.data.Movie;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe on 5/12/17.
 */
public class Client {

    private String url = "http://www.omdbapi.com/?t=tombstone";

    // Build url from user input
    public List<Movie> getData() {

        List<Movie> results = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String movie = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(movie);

            // Need solution for someone entering a movie that isn't in the database or doesn't exist.
            // Also need a solution for episodes and series?
            // Null pointer exception if user enters a title that doesn't exist. Need work around.
            // Need solution for empty title as well.

            String response = node.get("Response").asText(); // boolean
            String title = node.get("Title").asText();
            String year = node.get("Year").asText();
            String rated = node.get("Rated").asText();
            String released = node.get("Released").asText();
            String runtime = node.get("Runtime").asText();
            String genre = node.get("Genre").asText();
            String director = node.get("Director").asText();
            String writer = node.get("Writer").asText();
            String actors = node.get("Actors").asText();
            String plot = node.get("Plot").asText();
            String language = node.get("Language").asText();
            String country = node.get("Country").asText();
            String awards = node.get("Awards").asText();
            String poster = node.get("Poster").asText();
            String metaScore = node.get("Metascore").asText();
            String imdbRating = node.get("imdbRating").asText();
            String imdbVotes = node.get("imdbVotes").asText();
            String imdbID = node.get("imdbID").asText();
            String type = node.get("Type").asText();
            String boxOffice = node.get("BoxOffice").asText();
            String production = node.get("Production").asText();
            String website = node.get("Website").asText();


            Movie movieInfo = new Movie();

            movieInfo.setTitle(title);
            movieInfo.setYear(year);
            movieInfo.setRated(rated);
            movieInfo.setReleased(released);
            movieInfo.setRuntime(runtime);
            movieInfo.setGenre(genre);
            movieInfo.setDirector(director);
            movieInfo.setWriter(writer);
            movieInfo.setActors(actors);
            movieInfo.setAwards(awards);
            movieInfo.setPlot(plot);
            movieInfo.setLanguage(language);
            movieInfo.setCountry(country);
            movieInfo.setPoster(poster);
            movieInfo.setMetaScore(metaScore);
            movieInfo.setImdbRating(imdbRating);
            movieInfo.setImdbVotes(imdbVotes);
            movieInfo.setImdbID(imdbID);
            movieInfo.setType(type);
            movieInfo.setBoxOffice(boxOffice);
            movieInfo.setProduction(production);
            movieInfo.setWebsite(website);
            movieInfo.setRespone(response);

            results.add(movieInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
