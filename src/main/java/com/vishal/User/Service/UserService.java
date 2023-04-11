package com.vishal.User.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vishal.User.Entity.Hotel;
import com.vishal.User.Entity.Rating;
import com.vishal.User.Entity.User;
import com.vishal.User.Exception.ResourceNotFoundException;
import com.vishal.User.Repo.UserRepo;
import com.vishal.User.externalApi.HotelService;
import com.vishal.User.externalApi.RatingService;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private HotelService hotelService;

    public User saveUser(User user){
        
        return userRepo.save(user);

    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User getUser(Integer Uid){


        User user  = userRepo.findById(Uid).orElseThrow(() -> new ResourceNotFoundException("user not found"));

        // Rating[] usersWithRating = restTemplate.getForObject("http://RATINGSERVICE/rating/users/"+user.getUid(), Rating[].class);

        // List<Rating> users = Arrays.asList(usersWithRating);
        List<Rating> users = ratingService.getRatings(user.getUid());

        List<Rating> actUser =  users.stream().map(rating ->{

            // Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRating(actUser);

        return user;

    }

    public void deleteUser(Integer id){
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userRepo.delete(user);
    }

}
