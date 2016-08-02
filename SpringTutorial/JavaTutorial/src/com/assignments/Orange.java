package com.assignments;


public class Orange {
	public static void main (String [] args) {
	      StringBuffer a = new StringBuffer ("A");
	      StringBuffer b = new StringBuffer ("B");
	      change(a,b);
	      System.out.println(a+","+b);
	     }
	    static void change(StringBuffer x, StringBuffer y) {
	        y.append(x);
	        System.out.println(y);
	        y = x;
	        System.out.println(y);
	    }


}
