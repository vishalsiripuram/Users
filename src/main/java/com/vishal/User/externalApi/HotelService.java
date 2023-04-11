package com.vishal.User.externalApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vishal.User.Entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
  
  @GetMapping("/hotels/{hId}")
  Hotel getHotel(@PathVariable Integer hId);

}
