package moviebuddy.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import moviebuddy.MovieBuddyFactory;

/**
 * @author springrunner.kr@gmail.com
 */
public class MovieFinderTest {

	final MovieBuddyFactory movieBuddyFactory = new MovieBuddyFactory();
	final MovieFinder movieFinder = movieBuddyFactory.movieFinder();
	
	@Test
	void NotEmpty_directedBy() {
		List<Movie> movies = movieFinder.directedBy("Michael Bay");
		Assertions.assertEquals(3, movies.size());
	}
	
	@Test
	void NotEmpty_releasedYesrBy() {
		List<Movie> movies = movieFinder.releasedYearBy(2015);
		Assertions.assertEquals(225, movies.size());
	}
	
}
