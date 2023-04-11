package com.vishal.User.externalApi;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vishal.User.Entity.Rating;



@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
  
  @GetMapping("/rating/users/{uid}")
  List<Rating> getRatings(@PathVariable Integer uid);

}
