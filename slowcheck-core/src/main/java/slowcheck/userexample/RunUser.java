package slowcheck.userexample;

import java.io.IOException;

import org.scalacheck.Arbitrary;

import com.google.inject.Guice;
import com.google.inject.TypeType;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class RunUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
	    Injector inj = Guice.createInjector(new UserModule());

		@SuppressWarnings("unchecked")
		Arbitrary<User> arb = inj.getInstance(Key.get(TypeType.arb(User.class), Names.named("User")));
		System.out.println(arb.arbitrary().sample().get());
	}

}
