package moviebuddy.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;

public class CachingMovieReaderTest {
	
	@Test
	void caching() {
		CacheManager cacheManager = new ConcurrentMapCacheManager();
		MovieReader target = new DummyMovieReader();
		
		CachingMovieReader movieReader = new CachingMovieReader(cacheManager, target);
		
		Assertions.assertNull(movieReader.getCachedData());	// 캐시 없음
		
		List<Movie> movies = movieReader.loadMovies();	// 데이터를 불러올 때 캐시가 없다면 캐시를 생성함
		Assertions.assertNotNull(movieReader.getCachedData());	// 캐시 있음
		Assertions.assertSame(movieReader.loadMovies(), movies);	// 캐시에 저장된 값과 실제 값이 같은지 확인
	}
	
	class DummyMovieReader implements MovieReader {

		@Override
		public List<Movie> loadMovies() {
			return new ArrayList<>();
		}
		
	}

}
