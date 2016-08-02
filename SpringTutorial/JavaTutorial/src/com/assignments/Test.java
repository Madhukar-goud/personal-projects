package com.assignments;

public class Test implements Runnable{
    private int m, n;
    public synchronized void run() {
       try {
          for(int i =0; i<10; i++) {
              m++; n++;
              Thread.sleep(100);
              System.out.println(m+", "+n);
          }
       } 
       catch(InterruptedException e) {
       }
    }
    public static void main (String [] args) {
       try {
          Test a = new Test();
          new Thread(a).start();
          new Thread(a).start();
          String str = "420";
          str += 42;
          System.out.println(str);
       }
       catch(Exception e) {
       }
    }
}