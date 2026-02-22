// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MovieNotFoundException.class)
	public String handleMovieNotFound(MovieNotFoundException ex, Model model, HttpServletRequest request) {
		model.addAttribute("errorTitle", "Movie Not Found");
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("path", request.getRequestURI());
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String handleGeneral(Exception ex, Model model, HttpServletRequest request) {
		model.addAttribute("errorTitle", "Something went wrong");
		model.addAttribute("errorMessage", "An unexpected error occurred. Please try again.");
		model.addAttribute("path", request.getRequestURI());
		return "error";
	}
}
