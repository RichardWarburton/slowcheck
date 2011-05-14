package slowcheck.example;
import scala.math.BigInt;
import scala.runtime.AbstractFunction2;
import slowcheck.Prop;
import slowcheck.Prop2;

public class BigIntSpecification extends org.scalacheck.Properties {

	public BigIntSpecification() {
		super("BigInt");
		
		final BigInt zero = BigInt.int2bigInt(0);
		
		Prop2<BigInt, BigInt> jp2 = Prop.simple2(BigInt.class, BigInt.class);
		property().update("addition", jp2.forAll(new AbstractFunction2<BigInt, BigInt, Boolean>() {
			@Override
			public Boolean apply(BigInt a, BigInt b) {
				BigInt added = a.$plus(b);
				return Prop.implies(b.$greater$eq(zero),added.$greater$eq(a)) && Prop.implies(a.$greater$eq(zero),added.$greater$eq(b));
			}
		}));
		
		// NB: next two assume addition is correct
		property().update("subtraction", jp2.forAll(new AbstractFunction2<BigInt, BigInt, Boolean>() {
			@Override
			public Boolean apply(BigInt a, BigInt b) {
				BigInt added = a.$plus(b);
				return added.$minus(a).equals(b) && added.$minus(b).equals(a);
			}
		}));
		
		property().update("multiplication", jp2.forAll(new AbstractFunction2<BigInt, BigInt, Boolean>() {
			@Override
			public Boolean apply(BigInt a, BigInt b) {
				return a.$times(b).equals(b.$times(a));
			}
		}));

	}

}