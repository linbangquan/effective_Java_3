package com.lbq.chapter2.item03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
/**
 * 享有特权的客户端可以借助AccessibleObject.setAccessible方法，通过反射机制调用私有构造器。
 * 如果需要抵御这种攻击，可以修改构造器，让它在被要求创建第二个实例的时候抛出异常。
 * 要将Singleton类变成是可序列化的，仅仅在声明中加上implements Serializable是不够的。
 * 为了维护并Singleton, 必须声明所有实例域都是瞬时(transient)的，并提供一个readResolve方法。
 * @author 14378
 *
 */
public class Elvis2 implements Serializable {

	private static final long serialVersionUID = -6932715483424091807L;
	//final域私有静态成员
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2() {
		if(INSTANCE != null) {
			throw new RuntimeException("单例");
		}	
	}
	//公有静态工厂方法
	public static Elvis2 getInstance() {
		return INSTANCE;
	}
	public void leaveTheBuilding() {
		System.out.println("qqqqq");
	}
	
	private Object readResolve() {
		return INSTANCE;
	}
	public static void main(String[] args) {
		Elvis2 elvis2 = INSTANCE;
		elvis2.leaveTheBuilding();
		
		Elvis2 elvis2_1 = serializable(elvis2);
		System.out.println(elvis2_1 == elvis2);
		elvis2_1.leaveTheBuilding();
		Class<Elvis2> clazz = Elvis2.class;
		try {
			Constructor<Elvis2> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Elvis2 elvis = constructor.newInstance();
			elvis.leaveTheBuilding();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static Elvis2 serializable(Elvis2 elvis2) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Elvis2 elvis = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(elvis2);
			oos.flush();
			ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			elvis = (Elvis2) ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return elvis;
	}
}
