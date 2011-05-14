package slowcheck;

import org.scalacheck.Arbitrary;
import org.scalacheck.Prop;
import org.scalacheck.Prop$;
import org.scalacheck.Shrink;

import scala.Function1;
import scala.Function2;
import scala.Function3;

import com.google.inject.TypeType;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class JavaPropImplementation<T1,T2,T3> implements Prop3<T1,T2,T3>, Prop2<T1, T2>, Prop1<T1> {

	@Inject static Injector injector;
	
	private final PrettyWrapper<T1> p1;
	private final PrettyWrapper<T2> p2;
	private final PrettyWrapper<T3> p3;

	private final Shrink<T1> s1;
	private final Shrink<T2> s2;
	private final Shrink<T3> s3;
	
	private final Arbitrary<T1> a1;
	private final Arbitrary<T2> a2;
	private final Arbitrary<T3> a3;
	
	JavaPropImplementation(Class<T1> c1, Class<T2> c2, Class<T3> c3) {
		super();
		p1 = new PrettyWrapper<T1>();
		p2 = new PrettyWrapper<T2>();
		p3 = new PrettyWrapper<T3>();
		s1 = shrink(c1);
		s2 = shrink(c2);
		s3 = shrink(c3);
		a1 = arbitrary(c1);
		a2 = arbitrary(c2);
		a3 = arbitrary(c3);
	}
	
	@SuppressWarnings("all")
	private <T> Shrink<T> shrink(Class<T> cls) {
		if(cls != Void.class) {
			Key<Shrink> key = Key.get(TypeType.shrink(cls), Names.named(cls.getName()));
			return injector.getInstance(key);
		}
		return null;
	}
	
	@SuppressWarnings("all")
	private <T> Arbitrary<T> arbitrary(Class<T> cls) {
		if(cls != Void.class) {
			Key<Arbitrary> key = Key.get(TypeType.arb(cls), Names.named(cls.getName()));
			return injector.getInstance(key);
		}
		return null;
	}

	@Override
	public Prop forAll(Function1<T1, Boolean> f) {
		return Prop$.MODULE$.forAll(f, new PropBoolean(), a1, s1, p1);
	}
	
	@Override
	public Prop forAll(Function2<T1, T2, Boolean> f) {
		return Prop$.MODULE$.forAll(f, new PropBoolean(), a1, s1, p1, a2, s2, p2);
	}
	
	public Prop forAll(Function3<T1, T2, T3, Boolean> f) {
		return Prop$.MODULE$.forAll(f, new PropBoolean(), a1, s1, p1, a2, s2, p2, a3, s3, p3);
	}
	
}
