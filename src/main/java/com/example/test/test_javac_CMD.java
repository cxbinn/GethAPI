package com.example.test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.objectweb.asm.util.Printer;


public class test_javac_CMD {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		
		/*
		 * JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		 * int compilationResult = compiler.run(null, null, null, "/path/to/Test.java");
		 */
		
		//com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();  
		String classPath="/data/geth/tmp_java/test/example/foxconn/";
		
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("-Xlint:unchecked");
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null, null);
		//读入源文件
		Iterable fileObject = fileManager.getJavaFileObjects(classPath + "Test1.java");
		//编译
		JavaCompiler.CompilationTask task = compiler.getTask(
		                null, fileManager, null, null, null, fileObject);
		System.out.println(task.call());
		fileManager.close();
		//指定class路径，默认和源代码路径一致，加载class
		URL[] urls = new URL[]{new URL("file:"+"/data/geth/tmp_java/")};
		URLClassLoader loader = new URLClassLoader(urls);
		
		
//		Class<?> cls=loader.loadClass("test.example.foxconn.HelloWorld");
//		
//		//URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:" + "HelloWorld.java")});
//		//Object o = classLoader.loadClass("HelloWorld").newInstance();
//		Object result = null;
//		try {
//			Method method = cls.getDeclaredMethod("Hello");
//			//result = method.invoke(cls);
//			Field f=cls.getDeclaredField("FUNC_HELLO");
//			System.out.println(String.valueOf(f.get(null)));
//			//System.out.println(result);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	 

}
