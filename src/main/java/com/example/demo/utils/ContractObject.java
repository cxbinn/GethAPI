package com.example.demo.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.example.demo.configuration.GethProperties;

public class ContractObject {
	
	private Class<?> cls=null;
	private Object[] params=null;
	private Object origin=null;
	private String resource=GethProperties.path.getJava();
	private static URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
	public ContractObject(){
		
	}
	public void init(Object origin){
		this.origin=origin;
	}
	
	public void forClass(String name) throws MalformedURLException{
		
		try {
			cls=Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			forClass(resource,name);
		}
	}
	
	public void forClass(String url, String name) throws MalformedURLException {
		System.out.println("now it's loading class from:" + url);
		URL[] urls = new URL[] { new URL("file:" + url) };

		URLClassLoader loader = new URLClassLoader(urls, urlClassLoader);

		try {
			cls = loader.loadClass(GethProperties.path.getSolc_package() + "."
					+ name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Class<?> getContractClass(){
		return cls;
	}
	
	public void paramsReady(Object...objects){
		params=objects;
	}
	
	public Object invoke(String methodName,Class<?>...c){
		Object result=null;
		Object sucking=null;
		if(origin==null){
			//return null;
		}else{
			sucking=origin;
		}
		
		try {
			Method m=cls.getMethod(methodName,c);
			result=m.invoke(sucking, params);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			params=null;
		}
		return result;
	}
	public static void main(String[] args){
		
		
	}
	

}
