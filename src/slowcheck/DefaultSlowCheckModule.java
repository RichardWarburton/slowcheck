package slowcheck;

import org.scalacheck.Arbitrary;
import org.scalacheck.Shrink;

import scala.math.BigInt;

import com.google.inject.AbstractModule;
import com.google.inject.TypeType;
import com.google.inject.name.Names;

public class DefaultSlowCheckModule extends AbstractModule {

	@Override
	protected void configure() {
		bindShrink(String.class, Shrink.shrinkString());
		bindShrink(BigInt.class, Shrink.<BigInt>shrinkAny());
		bindArb(String.class, Arbitrary.arbString());
		bindArb(BigInt.class,Arbitrary.arbBigInt());
//		bindArb(BigDecimal.class,Arbitrary.arbBigDecimal());
//		bindArb(Date.class,Arbitrary.arbDate());
//		bindArb(Number.class,Arbitrary.arbNumber());
//		bindArb(Throwable.class,Arbitrary.arbThrowable());
//		bindArb(Params.class,Arbitrary.arbGenParams());
//		bindArb(org.scalacheck.Prop.class,Arbitrary.arbProp());
//		bindArb(BoxedUnit.class,Arbitrary.arbUnit());
		
		System.out.println("Penises");
		
		requestStaticInjection(JavaPropImplementation.class);
	}
	
	protected <T> void bindArb(Class<T> cls, Arbitrary<T> inst) {
		bind(TypeType.arb(cls)).annotatedWith(Names.named(cls.getName())).toInstance(inst);
	}
	
	protected <T> void bindShrink(Class<T> cls, Shrink<T> inst) {
		bind(TypeType.shrink(cls)).annotatedWith(Names.named(cls.getName())).toInstance(inst);
	}

}
