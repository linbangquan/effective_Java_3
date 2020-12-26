package com.lbq.chapter2.item06;

import java.util.regex.Pattern;

public class Test {

	/**
	 * 为了提升性能，应该显式地将正则表达式编译成一个Pattern实例(不可变)，让它成为类初始化的一部分，并将它缓存起来，每当调用isRomanNumberal方法的时候就重用同一个实例。
	 */
	private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	public static void main(String[] args) {
		String s = new String("bikini");// don't do this
		String str = "bikini";
		System.out.println("start...");
		long start = System.currentTimeMillis();
		sum3();//1275-1278-7540-7501-638-639-14750-14757
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("end...");
	}
	/**
	 * 这个实现的问题在于它依赖String.matches方法。虽然Stringmatches方法最易于查看一个字符串是否于正则表达式相匹配，但并不适合在注重性能的情形中重复使用。
	 * 问题在于，它的内部为正则表达式创建了一个Pattern实例，却只用了一次，之后就可以进行垃圾回收了。
	 * 创建Pattern实例的成本很高，因为需要将正则表达式编译成一个有限状态机。
	 * @param s
	 * @return
	 */
	static boolean isRomanNumberal(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
	static boolean isRomanNumberal2(String s) {
		return ROMAN.matcher(s).matches();
	}
	
	private static long sum() {
		Long sum = 0L;
		for(long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		return sum;
	}
	/**
	 * 自动装箱使得基本类型和装箱基本类型之间的差别变得模糊起来，但是并没有完全消除。
	 * 要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱。
	 * @return
	 */
	private static long sum2() {
		long sum = 0L;//用基本数据类型可以避免自动装箱。
		long maxValue = Integer.MAX_VALUE;//避免每次比较时，类型转化。
		for(long i = 0; i <= maxValue; i++) {
			sum += i;
		}
		return sum;
	}
	
	private static long sum3() {
		Long sum = 0L;
		for(Long i = 0L; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		return sum;
	}
}
