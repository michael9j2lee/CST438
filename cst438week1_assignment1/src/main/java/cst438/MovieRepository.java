package cst438;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
    @Query("SELECT m FROM Movie m ORDER BY title, date DESC")
	List<Movie> findAllMovies();
}
