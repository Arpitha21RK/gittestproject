package com.emids; //break through serialization/deserialization

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class singletonDemo1 {
	 public static void main(String[] args) throws Exception{
			Singleton1 s1=Singleton1.getInstance();
			Singleton1 s2=Singleton1.getInstance();
			System.out.println("s1:"+s1.hashCode());
			System.out.println("s2:"+s2.hashCode());
			
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("/home/arpithak/eclipse workspace/demoDebug/src/com/emids/singletonDemo1.ser"));
			oos.writeObject(s2);
			
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("/home/arpithak/eclipse workspace/demoDebug/src/com/emids/singletonDemo1.ser"));
	        Singleton1 s3=(Singleton1)ois.readObject();
	        
	        System.out.println("s3:"+s3.hashCode());
	        
			
					
	 }
 }
class Singleton1 implements Serializable
	 {
	 	private static Singleton1 stn=null;
	 	private Singleton1()
	 	{
	 		System.out.println("creating...");
	 	}
	 	public static Singleton1 getInstance()
	 	{
	 		if(stn==null)
	 			stn=new Singleton1();
	 		return stn;
	 	}
	 }

