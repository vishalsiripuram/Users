package com.vishal.User.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private Integer RatingId;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String feedback;

    private Hotel hotel;
}
