package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class MoviesController {


	@Autowired
	MovieRepository movieRepository;
	
	
	@GetMapping("/getMovies") // localhost:8080/hello?name=insertname
	public String movies(@RequestParam("title") String title, Model model) {
		model.addAttribute("title",title);
		model.addAttribute("time", new java.util.Date().toString());
		return "index";
	}
	
	@GetMapping("/movies/new")
	public String createPerson(Model model ) {
		Movie movie = new Movie();
		movie.setDate(new java.util.Date());

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
		return "movie_show";
	}
	
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		Iterable<Movie> movie = movieRepository.findAllMoviesDesc();
		model.addAttribute("movie",movie);
		return "movie_list";
	}
}
