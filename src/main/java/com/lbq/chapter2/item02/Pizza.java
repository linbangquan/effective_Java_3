package com.lbq.chapter2.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
/**
 * Builder pattern for class hierarchies
 * Builder模式也适用于类层次结构。
 * 注意，Pizza.Builder的类型是泛型(generic type), 带有一个递归类型参数(recursive type parameter), 它和抽象的self方法一样，允许在子类中适当地进行方法链接, 不需要转换类型。
 * 简而言之，如果类的构造器或者静态工厂中具有多个参数，设计这种类时，Builder模式就是一种不错的选择，特别是当大多数参数都是可选或者类型相同的时候。
 * @author 14378
 *
 */
public abstract class Pizza {

	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		abstract Pizza build();
		
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder){
		toppings = builder.toppings.clone();
	}
}
