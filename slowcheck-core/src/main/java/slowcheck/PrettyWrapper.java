package slowcheck;
import org.scalacheck.Pretty;
import org.scalacheck.Pretty$;

import scala.runtime.AbstractFunction1;


final class PrettyWrapper<T> extends AbstractFunction1<T,Pretty> {

	@Override
	public Pretty apply(T t) {
		return Pretty$.MODULE$.prettyAny(t);
	}

}
