package com.rks.student.dbconfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration @EnableTransactionManagement @EnableJpaRepositories(basePackages = "com.rks.student.studentrecord.repository", entityManagerFactoryRef = "secondaryEntityManagerFactory", transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDatabaseConfig
{
    @Value("${spring.datasource.secondary.url}")
    private String secondaryDbUrl;
    @Value("${spring.datasource.secondary.username}")
    private String secondaryDbUsername;
    @Value("${spring.datasource.secondary.password}")
    private String secondaryDbPassword;
    @Value("${spring.datasource.secondary.driver-class-name}")
    private String secondaryDbDriverClassName;
    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource()
    {
        return DataSourceBuilder.create().url( secondaryDbUrl ).username( secondaryDbUsername )
                .password( secondaryDbPassword ).driverClassName( secondaryDbDriverClassName ).build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory( EntityManagerFactoryBuilder builder,
                                                                                 @Qualifier("secondaryDataSource") DataSource secondaryDataSource )
    {
        return builder.dataSource( secondaryDataSource )
                .packages( "com.rks.student.studentrecord.entity" ).persistenceUnit( "secondary" )
                .build();
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager( @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory secondaryEntityManagerFactory )
    {
        return new JpaTransactionManager( secondaryEntityManagerFactory );
    }
}
