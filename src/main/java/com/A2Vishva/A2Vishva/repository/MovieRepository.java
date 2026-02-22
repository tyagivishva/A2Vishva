// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.repository;

import com.A2Vishva.A2Vishva.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m "
	    + "WHERE (:title IS NULL OR LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))) "
	    + "AND (:genre IS NULL OR LOWER(m.genre) LIKE LOWER(CONCAT('%', :genre, '%'))) "
	    + "AND (:minRating IS NULL OR m.rating >= :minRating)")
    List<Movie> searchMovies(@Param("title") String title,
			     @Param("genre") String genre,
			     @Param("minRating") Double minRating);
}
