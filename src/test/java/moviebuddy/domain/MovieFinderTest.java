package moviebuddy.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.MovieBuddyProfile;

/**
 * @author springrunner.kr@gmail.com
 */
@ActiveProfiles(MovieBuddyProfile.CSV_MODE)
@SpringJUnitConfig(MovieBuddyFactory.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = MovieBuddyFactory.class)
public class MovieFinderTest {

	//필드에 Autowired
	@Autowired
	MovieFinder movieFinder;
	
	//생성자에 Autowired
//	@Autowired
//	MovieFinderTest(MovieFinder movieFinder) {
//		this.movieFinder = movieFinder;
//	}
	
	//세터에 Autowired
//	@Autowired
//	void setMovieFinder(MovieFinder movieFinder) {
//		this.movieFinder = movieFinder; 
//	}
	
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
