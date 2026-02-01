package com.l2t.mr;

import lombok.Data;

@Data
public class UserMovieRating {
    private String user;
    private String movie;
    private double rating;
}
