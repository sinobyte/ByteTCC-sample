package com.bytesvc.consumer.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(SpringCloudConfiguration.class)
@Configuration
public class ConsumerConfig {

	@Bean(name = "mybatisDataSource")
	public DataSource getDataSourceForMybatis() {
		LocalXADataSource dataSource = new LocalXADataSource();
		dataSource.setDataSource(this.invokeGetDataSource());
		return dataSource;
	}

	public DataSource invokeGetDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://8.140.125.125:9002/inst02");
		bds.setUsername("naizhan");
		bds.setPassword("Guanli@2012");
		bds.setMaxTotal(50);
		bds.setInitialSize(20);
		bds.setMaxWaitMillis(60000);
		bds.setMinIdle(6);
		bds.setLogAbandoned(true);
		bds.setRemoveAbandonedOnBorrow(true);
		bds.setRemoveAbandonedOnMaintenance(true);
		bds.setRemoveAbandonedTimeout(1800);
		bds.setTestWhileIdle(true);
		bds.setTestOnBorrow(false);
		bds.setTestOnReturn(false);
		bds.setValidationQuery("select 'x' ");
		bds.setValidationQueryTimeout(1);
		bds.setTimeBetweenEvictionRunsMillis(30000);
		bds.setNumTestsPerEvictionRun(20);
		return bds;
	}

}