package com.lbq.chapter2.item04;
/**
 * 企图通过将类做成抽象类来强制该类不可被实例化是行不通的。该类可以被子类化，并且该子类也可以被实例化。这样做甚至会误导用户，以为这种类是专门为了继承而设计的。
 * 由于只有当类不包含显示的构造器时，编译器才会生成缺省的构造器，因此只要让这个类包含一个私有构造器，它就不能被实例化。
 * @author 14378
 *
 */
public class UtilityClass {

	private UtilityClass() {
		throw new AssertionError();
	}
}
