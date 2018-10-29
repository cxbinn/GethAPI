package com.example.demo.utils;

import java.io.FileInputStream;

import com.example.demo.configuration.GethProperties;

public class Loader extends ClassLoader{

	static int maxsize=10000;
	String namefile =GethProperties.path.getJava();
	public Class<?> load(String className) throws Exception{
		
		Class<?> ctmp=	this.findLoadedClass(className);
		//查看class是否已经被加载了
		if(ctmp!=null){
			System.out.println("class文件已经被加载了");
			return ctmp;
		}
		
		FileInputStream in=new FileInputStream(namefile+className.replace(".", "/")+".class");
		byte[] classbyte=new byte[maxsize];
		int readsize;
		readsize=in.read(classbyte);
		System.out.println("readsize:"+readsize);
		in.close();
		
		return defineClass(null, classbyte, 0,readsize);
	}
	
}