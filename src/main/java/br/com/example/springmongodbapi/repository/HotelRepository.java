package br.com.example.springmongodbapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.example.springmongodbapi.entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

	Hotel findByName(String name);
	List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{address.city:?0}")
	List<Hotel> findByCity(String city);
	
}
