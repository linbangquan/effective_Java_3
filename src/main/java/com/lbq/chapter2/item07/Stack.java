package com.lbq.chapter2.item07;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * 清空对象引用应该是一种例外，而不是一种规范行为。消除过期引用最好的方法是让包含该引用的变量结束其生命周期。如果你是在最紧凑的作用域范围内定义每个变量，这种情形就自然而然地发生。
 * 一般来说，只要类是自己管理内存，程序员就应该警惕内存泄漏问题。一旦元素被释放掉，则该元素中包含的任何对象引用都应该被清空。
 * 内存泄漏的另一个常见来源是缓存。
 * 如果你正好要实现这样的缓存：只要在缓存之外存在对某个项的键的引用，该项就有意义，那么就可以用WeakHashMap代表缓存；当缓存中的项过期之后，它们就会自动被删除。
 * 记住只有当所要的缓存项的生命周期是由该键的外部引用而不是由值决定时，WeakHashMap才有用处。
 * 更为常见的情形则是，“缓存项的生命周期是否有意义”并不是很容易确定，随着时间的推移，其中的项会变得越来越没有价值。
 * 在这种情况下，缓存应该时不时地清除掉没用的项。这项清理工作可以由一个后台线程（可能是ScheduledThreadPoolExecutor）来完成，或者也可以在缓存添加新条目的时候顺便进行清理。
 * LinkedHashMap类利用它的removeEldesEntry方法可以很容易地实现后一种方案。
 * 对于更加复杂的缓存，必须直接使用java.lang.ref。
 * 
 * 内存泄漏的第三个常见来源是监听器和其他回调。如果你实现了一个API，客户端在这个API中注册回调，却没有显式地取消注册，那么除非你采用某些动作，否则它们就会不断地堆积起来。
 * 确保回调立即被当作垃圾回收的最佳方法是只保存它们的弱引用(weak reference)，例如，只将它们保存成WeakHashMap中的键。
 * @author 14378
 *
 */
public class Stack {

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	public Object pop2() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}
	private void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
