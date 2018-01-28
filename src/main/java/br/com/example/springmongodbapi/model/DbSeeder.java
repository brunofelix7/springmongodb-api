package br.com.example.springmongodbapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import br.com.example.springmongodbapi.entity.Address;
import br.com.example.springmongodbapi.entity.Hotel;
import br.com.example.springmongodbapi.entity.Review;
import br.com.example.springmongodbapi.repository.HotelRepository;

//	@Component
public class DbSeeder implements CommandLineRunner{

    private HotelRepository hotelRepository;

    @Autowired
    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Sera executado quanto a aplicacao subir
     */
    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel("Marriot",130, new Address("Paris", "France"),
                Arrays.asList(
                    new Review("John", 8, false),
                    new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel("Ibis",90, new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel("Sofitel",200, new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        //  Drop all hotels
        this.hotelRepository.deleteAll();

        //  Add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(hotels);
    }
}
