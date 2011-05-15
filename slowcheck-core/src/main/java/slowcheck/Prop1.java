package slowcheck;

import org.scalacheck.Prop;

import scala.Function1;

public interface Prop1<T1> {

	/* (non-Javadoc)
	 * @see Prop.internal.Prop2#forAll(scala.Function1)
	 */
	public abstract Prop forAll(Function1<T1, Boolean> f);

}