package com.google.inject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.scalacheck.Arbitrary;
import org.scalacheck.Shrink;

@SuppressWarnings("rawtypes")
public class TypeType<T,R> implements ParameterizedType {

	private Class<T> cls;
	private Class<R> raw;

	private static <T,R> TypeLiteral<R> create(Class<T> cls, Class<R> raw) {
		return new TypeType<T, R>(cls, raw).toTypeLiteral();
	}
	
	public static <T> TypeLiteral<Arbitrary> arb(Class<T> cls) {
		return create(cls,Arbitrary.class);
	}
	
	public static <T> TypeLiteral<Shrink> shrink(Class<T> cls) {
		return create(cls,Shrink.class);
	}
	
	private TypeType(Class<T> cls, Class<R> raw) {
		super();
		this.cls = cls;
		this.raw = raw;
	}

	@Override
	public Type[] getActualTypeArguments() {
		return new Type[] {cls};
	}

	@Override
	public Type getOwnerType() {
		return null;
	}

	@Override
	public Type getRawType() {
		return raw;
	}
	
	public TypeLiteral<R> toTypeLiteral() {
		return new TypeLiteral<R>(this) {};
	}
	
}