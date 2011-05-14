package slowcheck.userexample;

import org.scalacheck.Arbitrary;

import scala.runtime.AbstractFunction2;
import slowcheck.ArbUtil;
import slowcheck.DefaultSlowCheckModule;

import com.google.inject.Provides;
import com.google.inject.name.Named;

public class UserModule extends DefaultSlowCheckModule {

	@Provides
	@Named("User")
	Arbitrary<User> providesUser(final @Named("java.lang.String") Arbitrary<String> arb) {
		return ArbUtil.resultOf(new AbstractFunction2<String,String,User>() {
			@Override
			public User apply(String n, String p) {
				return new User(n,p);
			}
		},arb,arb);
	}
}
