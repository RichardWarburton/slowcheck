package slowcheck;
import org.scalacheck.Prop;
import org.scalacheck.Prop$;

import scala.runtime.AbstractFunction1;


final class PropBoolean extends AbstractFunction1<Boolean,Prop> {

	@Override
	public Prop apply(Boolean b) {
		return Prop$.MODULE$.propBoolean(b);
	}
	
}
