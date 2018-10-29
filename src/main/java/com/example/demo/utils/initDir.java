package com.example.demo.utils;

import java.io.File;
import java.util.Calendar;

import com.example.demo.configuration.GethProperties;

public class initDir {
	private String path=GethProperties.path.getKeystore();
	
	private int YEAR;
	private int MONTH;
	private int DAY_OF_MONTH;
	public static void init(){
		initDir tmp=new initDir();
		tmp.mkdir();
	}
	private void mkdir(){
		initDate();
		String parent=GethProperties.path.getParent();
		String today=parent+"/"+YEAR+"/"+MONTH+"/"+DAY_OF_MONTH;
		String tomorrow=parent+"/"+YEAR+"/"+MONTH+"/"+(DAY_OF_MONTH+1);
		createDir(parent);
		createDir(today);
		createDir(today+"/"+GethProperties.path.getAbi());
		createDir(today+"/"+GethProperties.path.getJava());
		createDir(today+"/"+GethProperties.path.getSolc());
		
		createDir(tomorrow);
		createDir(tomorrow+"/"+GethProperties.path.getAbi());
		createDir(tomorrow+"/"+GethProperties.path.getJava());
		createDir(tomorrow+"/"+GethProperties.path.getSolc());
		
	}
	private void initDate(){
		Calendar tmp=Calendar.getInstance();
		tmp.setTimeInMillis(System.currentTimeMillis());
		
		//System.out.println(tmp.getTime());
		YEAR=tmp.get(tmp.YEAR);
		MONTH=tmp.get(tmp.MONTH)+1;
		DAY_OF_MONTH=tmp.get(tmp.DAY_OF_MONTH);
	}
	private boolean createDir(String path){
		File tmp=new File(path);
		//tmp.exists()
		return tmp.mkdirs();
	}

}
