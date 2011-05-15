package slowcheck;

public class BindingException extends RuntimeException {

	private static final long serialVersionUID = 106837610337757044L;

	BindingException(Class<?> cls, boolean isArb) {
		super("unable to find "+(isArb?"Arbitrary":"Shrink")+" for "+cls.getName());
	}

	public BindingException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
