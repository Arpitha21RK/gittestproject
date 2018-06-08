package com.emids;

public class thread {
	static class A extends Thread
	{
		public void run()
		{
			for(int i=0;i<2;i++)
			{
				System.out.println("a"+i);
			}
		}
	}
	static class B implements Runnable
	{

		public void run()
		{
			for(int i=0;i<2;i++)
			{
				System.out.println("b"+i);
			}
		}
	
	}
	public static void main(String[] args) {
		A a1=new A();
	a1.start();
	B b1=new B();
	Thread t1=new Thread(b1);
	t1.start();
	for(int i=0;i<2;i++)
	{
		System.out.println("main"+i);
	}
	}

}
