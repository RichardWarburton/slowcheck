package slowcheck;



public class Prop {
	
	public static<T1> Prop1<T1> simple1(Class<T1> c1) {
		return new JavaPropImplementation<T1, Void,Void>(c1, Void.class, Void.class);
	}
	
	public static<T1,T2> Prop2<T1,T2> simple2(Class<T1> c1, Class<T2> c2) {
		return new JavaPropImplementation<T1, T2,Void>(c1, c2, Void.class);
	}
	
	public static<T1,T2,T3> Prop3<T1,T2, T3> simple3(Class<T1> c1, Class<T2> c2,Class<T3> c3) {
		return new JavaPropImplementation<T1, T2,T3>(c1, c2, c3);
	}
	
	// NB: strict
	public static boolean implies(boolean l, boolean r) {
		return l?r:true;
	}
	
}
