package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.example.demo.utils.Geth;

public class BaseData {
	private static List<String> accounts;
	private static Calendar today = Calendar.getInstance();
	private static StringBuilder PATH_OF_DATE = new StringBuilder();

	private BaseData() {
	}

	public static ArrayList<String> getAccounts() {
		return new ArrayList<String>(accounts);
	}

	private static void setAccounts(List<String> accounts) {
		BaseData.accounts = accounts;
	}

	private static void updateTime() {
		synchronized (PATH_OF_DATE) {
			today.setTimeInMillis(System.currentTimeMillis());
			if (PATH_OF_DATE.length() > 0) {
				PATH_OF_DATE.delete(0, PATH_OF_DATE.length() - 1);
			}

			PATH_OF_DATE.append(today.get(Calendar.YEAR) + "/"
					+ (today.get(Calendar.MONTH) + 1) + "/"
					+ today.get(Calendar.DAY_OF_MONTH));
		}
	}

	public static Calendar getToday() {
		return today;
	}

	public static StringBuilder getPATH_OF_DATE() {
		return PATH_OF_DATE;
	}

	public static void update() {
		try {
			setAccounts(Geth.getAccounts());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateTime();
	}

}
