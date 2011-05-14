package slowcheck.example;

import slowcheck.DefaultSlowCheckModule;

import com.google.inject.Guice;

public class RunStringSpec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Guice.createInjector(new DefaultSlowCheckModule());
		StringSpecification ss = new StringSpecification();
		ss.main(args);
	}

}
