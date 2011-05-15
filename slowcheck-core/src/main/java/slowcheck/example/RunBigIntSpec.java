package slowcheck.example;

import slowcheck.DefaultSlowCheckModule;

import com.google.inject.Guice;

public class RunBigIntSpec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Guice.createInjector(new DefaultSlowCheckModule());
		BigIntSpecification ss = new BigIntSpecification();
		ss.main(args);
	}

}
