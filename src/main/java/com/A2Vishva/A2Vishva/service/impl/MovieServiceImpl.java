// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.service.impl;

import com.A2Vishva.A2Vishva.error.MovieNotFoundException;
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
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " was not found."));
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = getMovieById(id);
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
        Movie existing = getMovieById(id);
        movieRepository.delete(existing);
    }

    @Override
    public List<Movie> searchMovies(String title, String genre, Double minRating) {
        String normalizedTitle = (title == null || title.isBlank()) ? null : title.trim();
        String normalizedGenre = (genre == null || genre.isBlank()) ? null : genre.trim();
        return movieRepository.searchMovies(normalizedTitle, normalizedGenre, minRating);
    }
}
