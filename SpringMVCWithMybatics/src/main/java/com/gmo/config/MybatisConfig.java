/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package com.gmo.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.gmo.service" })
@EnableTransactionManagement
public class MybatisConfig {

	// Tạo bean dataSource
	@Bean
	public DriverManagerDataSource dataSource() throws IOException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		Properties properties = new Properties();
		InputStream user_props = this.getClass().getResourceAsStream("/application.properties");
		properties.load(user_props);
		dataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(properties.getProperty("spring.datasource.url"));
		dataSource.setUsername(properties.getProperty("spring.datasource.username"));
		dataSource.setPassword(properties.getProperty("spring.datasource.password"));
		return dataSource;
	}

	// đọc thông tin file cấu hình MyBatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        return new SqlSessionFactoryBuilder().build(reader);
	}

	// scan tất cả những mapper package
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.gmo.mapper");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScannerConfigurer;
	}

//    Có thể tạo @Bean cho mỗi interface mapper thay vì scan toàn bộ package
//    @Bean (name = "userMapper")
//    public UserMapper studentMapper() throws Exception {
//        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
//        return sessionTemplate.getMapper(UserMapper.class);
//    }
	
	
	// enable Spring transaction
	@Bean
	public DataSourceTransactionManager transactionManager() throws IOException {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());

		return txManager;
	}
}
