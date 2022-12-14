package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.mapper.HotelMapper;
import com.project.bedroommanagement.model.Hotel;
import com.project.bedroommanagement.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService;

    //GET
    @GetMapping("/hotels")
    public List<Hotel> getAllHotels(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize,
            @RequestParam(name = "hotel_name", required = false)String hotelName
    ){
        return hotelService.redirectingRequest(page, pageSize, hotelName);
    }

    //POST
    @PostMapping("/hotel")
    public Hotel insertHotel(@RequestBody HotelMapper hotelMapper){
        return hotelService.insertHotel(hotelMapper);
    }

    //DELETE
    @DeleteMapping("/hotel/{id}")
    public String deleteHotel(@PathVariable(name = "id")Long id){
        return hotelService.deleteHotel(id);
    }

    //PUT
    @PutMapping("/hotel/{id}")
    public Hotel putUpdate(
            @RequestBody HotelMapper hotelMapper,
            @PathVariable(name = "id")Long id
            ){
        return hotelService.putUpdate(id, hotelMapper);
    }
}
