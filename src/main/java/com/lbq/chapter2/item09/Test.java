package com.lbq.chapter2.item09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 	try-with-resources优先于try-finally
 * 1.当Java7引入try-with-resources语句时，所有这些问题一下子就全部解决了。要使用这个构造资源，必须先实现AutoCloseable接口，其中包含了单个返回void的close方法。
 * 2.使用try-with-resources不仅使代码变得更简洁易懂，也更容易进行诊断。以firstLineOfFile方法为例，如果调用readLine和（不可见的）close方法都抛出异常，后一个
 * 	异常就会被禁止，以保留第一个异常。事实上，为了保留你想要看到的那个异常，即便多个异常就可以被禁止。这些被禁止的异常并不是简单地被抛弃了，而是会被打印在堆栈轨迹中，并注明它们是被禁止的异常。
 * 	通过编程调用getSuppressed方法还可以访问到它们，getSuppressed方法也已经添加在Java7的Throwable中了。
 * 3.结论很明显：在处理必须关闭的资源时，始终要优先考虑用try-with-resources，而不是用try-finally。
 * @author 14378
 *
 */
public class Test {
	private static final int BUFFER_SIZE = 1024;
	public static String firstLineOfFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		}finally {
			br.close();
		}
	}
	
	public static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			}finally {
				out.close();
			}
		}finally {
			in.close();
		}
	}
	
	public static String firstLineOfFile2(String path) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			return br.readLine();
		}
	}
	
	public static void copy2(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dst)){
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		}
	}
	
	public static String firstLineOfFile3(String path) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			return br.readLine();
		}catch(IOException e) {
			return "";
		}
	}
}
