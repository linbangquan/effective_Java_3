package com.lbq.chapter2.item03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
/**
 * 单元素的枚举类型经常成为实现Singleton的最佳方法。
 * 注意，如果Singleton必须扩展一个超类，而不是扩展Enum的时候，则不宜使用这个方法（虽然可以声明枚举去实现接口）。
 * @author 14378
 *
 */
public enum Elvis3 {

	INSTANCE;
	
	public void leaveTheBuilding() {
		System.out.println("qqqqq");
	}
	
	public static void main(String[] args) {
		INSTANCE.leaveTheBuilding();
		
		Elvis3 elvis3 = serializable(INSTANCE);
		System.out.println(elvis3 == INSTANCE);
		elvis3.leaveTheBuilding();
		Class<Elvis3> clazz = Elvis3.class;
		try {
			Constructor<Elvis3> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Elvis3 elvis = constructor.newInstance();
			elvis.leaveTheBuilding();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static Elvis3 serializable(Elvis3 elvis3) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Elvis3 elvis = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(elvis3);
			oos.flush();
			ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			elvis = (Elvis3) ois.readObject();
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
