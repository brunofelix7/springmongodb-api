package br.com.example.springmongodbapi.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.springmongodbapi.entity.Hotel;
import br.com.example.springmongodbapi.repository.HotelRepository;

@RestController
@RequestMapping(path = "/hotels")
public class HotelResource {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelResource(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //	GET
    @GetMapping
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }
    
    //	GET - ById
    @GetMapping(path = "/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel = this.hotelRepository.findOne(id);
        return hotel;
    }
    
    //	GET - ByPricePerNight
    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
    	List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    	return hotels;
    }
    
    //	GET - ByName
    @GetMapping("/name/{name}")
    public Hotel getName(@PathVariable("name") String name){
    	Hotel hotel = this.hotelRepository.findByName(name);
    	return hotel;
    }
    
    //	GET - ByCity
    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
    	List<Hotel> hotels = this.hotelRepository.findByCity(city);
    	return hotels;
    }
    
    //	POST
    @PostMapping
    public Hotel save(@RequestBody Hotel hotel){
    	this.hotelRepository.insert(hotel);
    	return hotel;
    }
    
    //	PUT
    @PutMapping
    public void update(@RequestBody Hotel hotel){
    	this.hotelRepository.save(hotel);
    }
    
    //	DELETE
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") String id){
    	this.hotelRepository.delete(id);
    }
    
}
