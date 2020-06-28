package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoviesController {


	@Autowired
	MovieRepository movieRepository;
	
	
	@GetMapping("/movies/new")
	public String createPerson(Model model ) {
		Movie movie = new Movie();
		model.addAttribute("movie",movie);
		return "movie_form";
	}
	
	@PostMapping("/movies")
	public String processPersonForm(@Valid Movie movie,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "movie_form";
		}


		movieRepository.save(movie);
		Iterable<Movie> movies = movieRepository.findAllMovies();
		model.addAttribute("movie",movies);
		return "movie_list";
	}
	
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		Iterable<Movie> movie = movieRepository.findAllMovies();
		model.addAttribute("movie",movie);
		return "movie_list";
	}
}
