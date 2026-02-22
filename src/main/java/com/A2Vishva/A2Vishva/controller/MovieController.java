// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.controller;

import com.A2Vishva.A2Vishva.model.Movie;
import com.A2Vishva.A2Vishva.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/list";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String genre,
                               @RequestParam(required = false) Double minRating,
                               Model model) {
        model.addAttribute("movies", movieService.searchMovies(title, genre, minRating));
        model.addAttribute("title", title);
        model.addAttribute("genre", genre);
        model.addAttribute("minRating", minRating);
        return "movies/search";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("formTitle", "Add Movie");
        model.addAttribute("submitLabel", "Create Movie");
        return "movies/form";
    }

    @PostMapping
    public String createMovie(@Valid @ModelAttribute("movie") Movie movie,
                              org.springframework.validation.BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formTitle", "Add Movie");
            model.addAttribute("submitLabel", "Create Movie");
            return "movies/form";
        }
        movieService.createMovie(movie);
        redirectAttributes.addFlashAttribute("successMessage", "Movie added successfully.");
        return "redirect:/movies";
    }

    @GetMapping("/{id}")
    public String viewMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movies/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("formTitle", "Edit Movie");
        model.addAttribute("submitLabel", "Update Movie");
        return "movies/form";
    }

    @PostMapping("/{id}")
    public String updateMovie(@PathVariable Long id,
                              @Valid @ModelAttribute("movie") Movie movie,
                              org.springframework.validation.BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formTitle", "Edit Movie");
            model.addAttribute("submitLabel", "Update Movie");
            return "movies/form";
        }
        movieService.updateMovie(id, movie);
        redirectAttributes.addFlashAttribute("successMessage", "Movie updated successfully.");
        return "redirect:/movies";
    }

    @GetMapping("/{id}/delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movies/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        movieService.deleteMovie(id);
        redirectAttributes.addFlashAttribute("successMessage", "Movie deleted successfully.");
        return "redirect:/movies";
    }
}
