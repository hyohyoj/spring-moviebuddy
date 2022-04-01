package moviebuddy.data;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.AopTestUtils;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.MovieBuddyProfile;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;

@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@SpringJUnitConfig(MovieBuddyFactory.class)
@TestPropertySource(properties = "movie.metadata=movie_metadata.xml")
public class XmlMovieReaderTest {
	
	MovieReader movieReader;
	
	@Autowired
	XmlMovieReaderTest(MovieReader movieReader) {
		this.movieReader = movieReader;
	}
	
	@Test
	void NotEmpty_LoadedMovies() {
		List<Movie> movies = movieReader.loadMovies();
		Assertions.assertEquals(1375, movies.size());
	}
	
	@Test
	void Check_MovieReaderType() {
		Assertions.assertTrue(AopUtils.isAopProxy(movieReader));							// movieReader가 프록시 객체인지 확인
																							// 맞다면
		MovieReader target = AopTestUtils.getTargetObject(movieReader);						// movieReader의 타겟을 꺼내서 
		Assertions.assertTrue(XmlMovieReader.class.isAssignableFrom(target.getClass()));	// XmlMovieReader 타입인가를 확인
	}

}