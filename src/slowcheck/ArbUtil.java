package slowcheck;

import org.scalacheck.Arbitrary;
import org.scalacheck.Gen$;

import scala.Function1;
import scala.Function2;
import scala.Function3;

public class ArbUtil {

	public static <T1,T2,R> Arbitrary<R> resultOf(final Function2<T1, T2, R> f, final Arbitrary<T1> a1, final Arbitrary<T2> a2) {
		return new Arbitrary<R>() {
			@Override
			public org.scalacheck.Gen<R> arbitrary() {
				return Gen$.MODULE$.resultOf(f,a1,a2);
			}
		};
	}
	
	public static <T,R> Arbitrary<R> resultOf(final Function1<T,R> f, final Arbitrary<T> a1) {
		return new Arbitrary<R>() {
			@Override
			public org.scalacheck.Gen<R> arbitrary() {
				return Gen$.MODULE$.resultOf(f,a1);
			}
		};
	}
	
	public static <T1,T2,T3,R> Arbitrary<R> resultOf(final Function3<T1, T2, T3, R> f, final Arbitrary<T1> a1, final Arbitrary<T2> a2, final Arbitrary<T3> a3) {
		return new Arbitrary<R>() {
			@Override
			public org.scalacheck.Gen<R> arbitrary() {
				return Gen$.MODULE$.resultOf(f,a1,a2,a3);
			}
		};
	}
	
}
