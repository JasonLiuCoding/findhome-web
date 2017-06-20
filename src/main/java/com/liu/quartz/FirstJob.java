package com.liu.quartz;

import javax.sql.DataSource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class FirstJob extends QuartzJobBean{

	public void setParamBean(DataSource dataSource) {
		System.out.println(String.format("FirstJob get ParamBean:%s", dataSource == null ? "?" : dataSource.toString()));
	}

	@Override
	protected void executeInternal(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		System.out.println("I am FirstJob! welcome!");
	}
}
