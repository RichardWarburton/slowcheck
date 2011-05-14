package slowcheck;

import org.scalacheck.Prop;

import scala.Function1;
import scala.Function2;

public interface Prop2<T1, T2> {

	public abstract Prop forAll(Function1<T1, Boolean> f);

	public abstract Prop forAll(Function2<T1, T2, Boolean> f);

}