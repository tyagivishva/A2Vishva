// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.config;

import com.A2Vishva.A2Vishva.model.Movie;
import com.A2Vishva.A2Vishva.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {
        if (movieRepository.count() == 0) {
            movieRepository.save(new Movie("Inception", "Sci-Fi", 2010, 8.8, "Christopher Nolan", 148));
            movieRepository.save(new Movie("The Shawshank Redemption", "Drama", 1994, 9.3, "Frank Darabont", 142));
            movieRepository.save(new Movie("Spirited Away", "Animation", 2001, 8.6, "Hayao Miyazaki", 125));
        }
    }
}
