package slowcheck;

import org.scalacheck.Prop;

import scala.Function1;
import scala.Function2;
import scala.Function3;

public interface Prop3<T1, T2, T3> {

	public abstract Prop forAll(Function1<T1, Boolean> f);

	public abstract Prop forAll(Function2<T1, T2, Boolean> f);

	public abstract Prop forAll(Function3<T1, T2, T3, Boolean> f);

}