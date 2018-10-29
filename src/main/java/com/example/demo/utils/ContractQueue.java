package com.example.demo.utils;

import java.util.HashMap;
import java.util.Hashtable;


/**
 * load contract queue
die if unused or timeout
can not be read by many clients
limited total
serialized?
concurrent\

 * @author ms
 *
 */
public class ContractQueue {
	private static final int maxTotal=0;
	private static final int living_time=0;
	
	private static HashMap queue=new HashMap();
	
	private class Contract{
		private String serialization;
		private boolean status;
		private int load_date;
		private int last_using;
		
		private ContractObject contractObject;
		private Contract(ContractObject contractObject){
			if(contractObject==null){
				
			}
		}
		
	}
	
	public void add(ContractObject co){
		Contract tmp=new Contract(null);
		
	}
	
	public boolean remove(Contract contract){
		
		return false;
	}
	
	public boolean isBusy(ContractObject contractObject){
		return false;
	}
	
	

}
