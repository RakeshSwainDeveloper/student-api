//package com.rks.student.dbconfig;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//public class SecondaryDatabaseConfig {
//
//	@Bean(name = "secondaryDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.secondary")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "secondaryEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("secondaryDataSource") DataSource dataSource) {
//		return builder.dataSource(dataSource).packages("com.rks.student.studentrecord.entity")
//				.persistenceUnit("secondary").build();
//	}
//
//	@Bean(name = "secondaryTransactionManager")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//
//}
