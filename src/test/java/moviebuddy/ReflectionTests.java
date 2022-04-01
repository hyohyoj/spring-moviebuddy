package moviebuddy;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ReflectionTests {
	
	@Test
	void objectCreateAndMethodCall() throws Exception {
		// Without reflection
		Duck duck = new Duck();
		duck.quack();
		
		// With reflection
		Class<?> duckClass = Class.forName("moviebuddy.ReflectionTests$Duck");	//클래스 찾아옴
		Object duckObject = duckClass.getDeclaredConstructor().newInstance();	//찾아온 클래스로부터 객체 생성함
		Method quackMethod = duckObject.getClass().getDeclaredMethod("quack", new Class<?>[0]);	//메소드 찾아옴 이름-quack 인자-없음[0]
		quackMethod.invoke(duckObject);	// 메소드 호출
	}
	
	static class Duck {
		
		void quack() {
			System.out.println("꽥꽥!");
		}
	}

}
