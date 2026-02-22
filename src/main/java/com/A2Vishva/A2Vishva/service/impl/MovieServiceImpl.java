// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.service.impl;

import com.A2Vishva.A2Vishva.model.Movie;
import com.A2Vishva.A2Vishva.repository.MovieRepository;
import com.A2Vishva.A2Vishva.service.MovieService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = movieRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setReleaseYear(movie.getReleaseYear());
        existing.setRating(movie.getRating());
        existing.setDirector(movie.getDirector());
        existing.setDurationMinutes(movie.getDurationMinutes());
        return movieRepository.save(existing);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
