package com.omdbexplorer.explorer.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omdbexplorer.explorer.data.Movie;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String url = "http://www.omdbapi.com/?t=";

    // Build url from user input
    // Return a list of Movie objects as strings
    public List<Movie> getData(String keyword) {
        List<Movie> results = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        try {
            String movie = restTemplate.getForObject(url+= URLEncoder.encode(keyword, "UTF-8"), String.class);
            JsonNode node = mapper.readTree(movie);

            // Return an empty list if there is an error with the search
            String response = getText(node, "Response");
            if (response.equalsIgnoreCase("false")) {
                return results;
            }

            String title = getText(node, "Title");
            String year = getText(node, "Year");
            String rated = getText(node, "Rated");
            String released = getText(node, "Released");
            String runtime = getText(node, "Runtime");
            String genre = getText(node, "Genre");
            String director = getText(node, "Director");
            String writer = getText(node, "Writer");
            String actors = getText(node, "Actors");
            String plot = getText(node, "Plot");
            String language = getText(node, "Language");
            String country = getText(node, "Country");
            String awards = getText(node, "Awards");
            String poster = getText(node, "Poster");
            String metaScore = getText(node, "Metascore");
            String imdbRating = getText(node, "imdbRating");
            String imdbVotes = getText(node, "imdbVotes");
            String imdbID = getText(node, "imdbID");
            String type = getText(node, "Type");
            String boxOffice = getText(node, "BoxOffice");
            String production = getText(node, "Production");
            String website = getText(node, "Website");

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
            movieInfo.setResponse(response);

            results.add(movieInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    private String getText(JsonNode node, String fieldName) {
        if (node.get(fieldName) != null) {
            return node.get(fieldName).asText();
        }
        return "";
    }
}
