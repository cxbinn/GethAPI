package com.example.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.BaseData;
import com.example.demo.utils.initDir;

@Component
public class mkdir_schedule {
	@Scheduled(cron = "0 0 * * * *")
	public void compileFile(){
		BaseData.update();
		initDir.init();
	}

}
