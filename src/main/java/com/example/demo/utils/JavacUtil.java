package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.example.demo.configuration.GethProperties;

public class JavacUtil {
	private static String classPath=GethProperties.path.getJava()+GethProperties.path.getSolc_package().replace(".", "/")+"/";
	private static ArrayList<String> options = new ArrayList<String>();
	static{
		//ops.add("-Xlint:unchecked");
		options.add("-classpath");
        StringBuilder sb = new StringBuilder();
        URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
        for (URL url : urlClassLoader.getURLs()) {
            sb.append(url.getFile()).append(File.pathSeparator);
        }
        options.add(sb.toString());
	}
	private static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	private static StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null, null);
	
	private JavacUtil(){}
	/***
	 * 
	 * @param sourcefile --full path
	 * @return
	 */
	public static boolean javac(String sourcefile){
		
		//读入源文件
		Iterable fileObject = fileManager.getJavaFileObjects(sourcefile);
		//编译
		JavaCompiler.CompilationTask task = compiler.getTask(
		                null, fileManager, null, options, null, fileObject);
		boolean result=task.call();
		try {
			fileManager.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
