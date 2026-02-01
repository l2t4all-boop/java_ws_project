package com.l2t.mr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MovieRecommenderService {


    public void recommendMovies(String user){

    }



    private List<UserMovieRating> getUserMovieRatingFromJsonFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return
                    objectMapper.readValue(
                            this.getClass().getResource("/movie_recommendation.json").getFile(),
                            new TypeReference<List<UserMovieRating>>() {}
                    );
        } catch (Exception e) {
            System.out.println("While reading file :"+e);
        }
        throw new RuntimeException("Something went wrong");
    }
}
