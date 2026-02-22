// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.service;

import com.A2Vishva.A2Vishva.model.Movie;
import java.util.List;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovieById(Long id);

	Movie createMovie(Movie movie);

	Movie updateMovie(Long id, Movie movie);

	void deleteMovie(Long id);

	List<Movie> searchMovies(String title, String genre, Double minRating);
}
