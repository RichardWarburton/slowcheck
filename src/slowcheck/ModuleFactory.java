package slowcheck;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.scalacheck.Arbitrary;
import org.scalacheck.Gen.Params;
import org.scalacheck.Shrink;
import org.scalacheck.Shrink$;

import scala.math.BigDecimal;
import scala.math.BigInt;
import scala.runtime.BoxedUnit;

public class ModuleFactory {

	private Map<Class<?>,Shrink<?>> shrinks;
	private Map<Class<?>,Arbitrary<?>> arbs;
	
	public ModuleFactory() {
		shrinks = new HashMap<Class<?>, Shrink<?>>();
		arbs = new HashMap<Class<?>, Arbitrary<?>>();
		bindScalaCheckDefaults();
	}
	
	private void bindScalaCheckDefaults() {
		bindShrink(String.class, Shrink$.MODULE$.shrinkString());
		bindArb(String.class, Arbitrary.arbString());
		bindArb(BigInt.class,Arbitrary.arbBigInt());
		bindArb(BigDecimal.class,Arbitrary.arbBigDecimal());
		bindArb(Date.class,Arbitrary.arbDate());
		bindArb(Number.class,Arbitrary.arbNumber());
		bindArb(Throwable.class,Arbitrary.arbThrowable());
		bindArb(Params.class,Arbitrary.arbGenParams());
		bindArb(org.scalacheck.Prop.class,Arbitrary.arbProp());
		bindArb(BoxedUnit.class,Arbitrary.arbUnit());
	}

	@SuppressWarnings("unchecked")
	public <T> Shrink<T> shrink(Class<T> cls) {
		Shrink<?> shrink = shrinks.get(cls);
		if(shrink != null) {
			return (Shrink<T>) shrink;
		}
		return Shrink.shrinkAny();
	}
	
	@SuppressWarnings("unchecked")
	public <T> Arbitrary<T> arb(Class<T> cls) {
		Arbitrary<?> arbitrary = arbs.get(cls);
		if(arbitrary != null) {
			return (Arbitrary<T>) arbitrary;
		}
		return (Arbitrary<T>) Arbitrary.arbAnyVal();
	}
	
	protected <T> void bindArb(Class<T> what, Arbitrary<T> to) {
		arbs.put(what, to);
	}
	
	protected <T> void bindShrink(Class<T> what, Shrink<T> to) {
		shrinks.put(what, to);
	}
	
}
