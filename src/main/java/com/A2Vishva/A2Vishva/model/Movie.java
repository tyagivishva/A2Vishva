// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is required")
	@Size(max = 150, message = "Title must be 150 characters or less")
	private String title;

	@NotBlank(message = "Genre is required")
	@Size(max = 50, message = "Genre must be 50 characters or less")
	private String genre;

	@NotNull(message = "Release year is required")
	@Min(value = 1888, message = "Release year must be 1888 or later")
	@Max(value = 2100, message = "Release year must be 2100 or earlier")
	private Integer releaseYear;

	@NotNull(message = "Rating is required")
	@DecimalMin(value = "0.0", message = "Rating must be between 0 and 10")
	@DecimalMax(value = "10.0", message = "Rating must be between 0 and 10")
	private Double rating;

	@NotBlank(message = "Director is required")
	@Size(max = 100, message = "Director must be 100 characters or less")
	private String director;

	@NotNull(message = "Duration is required")
	@Min(value = 1, message = "Duration must be at least 1 minute")
	private Integer durationMinutes;

	public Movie() {
	}

	public Movie(String title, String genre, Integer releaseYear, Double rating, String director, Integer durationMinutes) {
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.director = director;
		this.durationMinutes = durationMinutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
}
