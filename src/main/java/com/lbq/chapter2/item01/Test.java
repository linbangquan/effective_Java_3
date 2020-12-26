package com.lbq.chapter2.item01;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 用静态工厂方法代替构造器
 * 1.静态工厂方法与构造器不同的第一大优势在于，它们有名称。
 * 2.静态工厂方法与构造器不同的第二大优势在于，不必在每次调用它们的时候都创建一个新对象。
 * 3.静态工厂方法与构造器不同的第三大优势在于，它们可以返回原返回类型的任何子类型的对象。
 * 		使用这种静态工厂方法时，甚至要求客户端通过接口来引用被返回的对象，而不是通过它的实现类来引用被返回的对象，这是一种良好的习惯。
 * 4.静态工厂方法与构造器不同的第四大优势在于，所返回的对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值。
 * 5.静态工厂方法于构造器不同的第五大优势在于，方法返回的对象所属的类，在编写包含该静态方法的类时可以不存在。
 * 6.静态工厂方法的主要缺点在于，类如果不含公有的或者受保护的构造器，就不能被子类化。
 * 7.静态工厂方法的第二个缺点在于，程序员很难发现它们。
 *
 *	简而言之，静态工厂方法和公有构造器都各有用处，我们需要理解它们各自的长处。静态工厂经常更加合适，因此切忌第一反应就是提供公有的构造器，而不先考虑静态工厂。
 * @author 14378
 *
 */
public class Test {

	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger(1, 1, new Random());
		BigInteger bigIntegerPrime = BigInteger.probablePrime(1, new Random());
		
		//下面是静态工厂方法的一些惯用名称。这里只列出了其中的一小部分：
		//from————类型转换方法，它只有单个参数，返回该类型的一个相对应的实例，例如:
		//Date d = Date.from(instant);
		
		//of————聚合方法，带有多个参数，返回该类型的一个实例，把它们合并起来，例如：
		//Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
		
		//valueOf————比from和of更烦琐的一种替代方法，例如：
		BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
		
		//instance或者getInstance————返回的实例是通过方法的（如有）参数来描述的，但是不能说于参数具有同样的值，例如：
		//StackWalker luke = StackWalker.getInstance(options);
		
		//create或者newInstance————像instance或者getInstance一样，但create或者newInstance能够确保每次调用都返回一个新的实例，例如：
		Object newArray = Array.newInstance(String.class, 2);
		
		//getType————像getInstance一样，但是在工厂方法处于不同的类中时候使用。Type表示工厂方法所返回的对象类型，例如：
		//FileStore fs = Files.getFileStore(path);
		
		//newType————像newInstance一样，但是在工厂方法处于不同的类中时候使用。Type表示工厂方法所返回的对象类型，例如：
		//BufferedReader bufferedReader = Files.newBufferedReader(path);
		
		//type————getType和newType简洁的替代方式，例如：
		//List<Complaint> litany = Collections.list(legacyLitany);
	}
	
}
