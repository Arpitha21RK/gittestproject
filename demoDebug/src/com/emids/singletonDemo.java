package com.emids;//breaking through Reflection

import java.lang.reflect.Constructor;

public class singletonDemo{
 public static void main(String[] args) throws Exception{
	Singleton s1=Singleton.getInstance();
	Singleton s2=Singleton.getInstance();
	System.out.println("s1:"+s1.hashCode());
	System.out.println("s2:"+s2.hashCode());
	
	Class clz=Class.forName("com.emids.Singleton");
	Constructor<Singleton> con=clz.getDeclaredConstructor();
	con.setAccessible(true);
	Singleton s3=con.newInstance();
	System.out.println("s3:"+s3.hashCode());
}
}
class Singleton
{
	private static Singleton stn=null;
	private Singleton()
	{
		System.out.println("creating...");
	}
	public static Singleton getInstance()
	{
		if(stn==null)
			stn=new Singleton();
		return stn;
	}
}