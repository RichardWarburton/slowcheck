package slowcheck.example;
import scala.runtime.AbstractFunction2;
import scala.runtime.AbstractFunction3;
import slowcheck.Prop;
import slowcheck.Prop2;

public class StringSpecification extends org.scalacheck.Properties {

	public StringSpecification() {
		super("String");
		
		Prop2<String, String> jp2 = Prop.simple2(String.class, String.class);
		property().update("startsWith", jp2.forAll(new AbstractFunction2<String, String, Boolean>() {
			@Override
			public Boolean apply(String a, String b) {
				return (a + b).startsWith(a);
			}
		}));
		
		property().update("endsWith", jp2.forAll(new AbstractFunction2<String, String, Boolean>() {
			@Override
			public Boolean apply(String a, String b) {
				return (a + b).endsWith(b);
			}
		}));
		
		property().update("concat", jp2.forAll(new AbstractFunction2<String, String, Boolean>() {
			@Override
			public Boolean apply(String a, String b) {
				return (a+b).length() >= a.length() && (a+b).length() >= b.length();
			}
		}));
		
		property().update("substring", jp2.forAll(new AbstractFunction2<String, String, Boolean>() {
			@Override
			public Boolean apply(String a, String b) {
				return (a+b).substring(a.length()).equals(b);
			}
		}));
		
		property().update("substring", Prop.simple3(String.class, String.class, String.class).forAll(new AbstractFunction3<String, String, String,Boolean>() {
			@Override
			public Boolean apply(String a, String b, String c) {
				return (a+b+c).substring(a.length(), a.length()+b.length()).equals(b);
			}
		}));

	}

}

