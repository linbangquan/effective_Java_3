package com.lbq.chapter2.item05;

import java.util.List;
import java.util.Objects;
/**
 * 静态工具类和Singleton类不适合于需要引用底层资源的类。
 * 满足该需求的是依赖注入模式，当创建一个新的实例时，就将该资源传到构造器中。
 * 
 * 依赖注入模式的另一种有用的变体是，将资源工厂(factory)传给构造器。工厂是可以被重复调用来创建类型的实例的一个对象。这类工厂具体表现为工厂方法(Factory Method)模式。
 * 在java8中增加的接口Supplier<T>，最适合用于表示工厂。
 * 带有Supplier<T>的方法，通常应该限制输入工厂的类型参数使用有限制的通配符类型(bounded wildcard type)，以便客户端能够传入一个工厂，来创建指定类型的任意子类型。
 * @author 14378
 *
 */
public class SpellChecker3 {
	
	private final Lexicon dictionary;
	
	public SpellChecker3(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	
	public boolean isValid(String word) {
		return false;
	}
	
	public List<String> suggestions(String typo){
		return null;
	}
}
