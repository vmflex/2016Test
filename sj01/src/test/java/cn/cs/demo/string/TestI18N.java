package cn.cs.demo.string;

import java.util.ResourceBundle;

public class TestI18N {

	public static void main(String[] args) {
		ResourceBundle b1 = ResourceBundle.getBundle("cn.cs.demo.string.a");
		ResourceBundle b11 = ResourceBundle.getBundle("cn.cs.demo.string.a");
		ResourceBundle b2 = ResourceBundle.getBundle("cn.cs.demo.string.b");
		ResourceBundle b3 = ResourceBundle.getBundle("cn.cs.demo.string.c");
		
		System.out.println(b1);
		System.out.println(b11);
		System.out.println(b2);
		System.out.println(b3);
		
		System.out.println(b1.getString("a"));
		System.out.println(b2.getString("b"));
		System.out.println(b3.getString("c"));

	}

}
