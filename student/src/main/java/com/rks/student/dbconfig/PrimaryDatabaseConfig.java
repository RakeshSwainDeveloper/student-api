package com.rks.student.dbconfig;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration @EnableTransactionManagement @EnableJpaRepositories(basePackages = "com.rks.student.studentcentraldb.repository", entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class PrimaryDatabaseConfig
{
    @Value("${spring.datasource.primary.url}")
    private String primaryDbUrl;
    @Value("${spring.datasource.primary.username}")
    private String primaryDbUsername;
    @Value("${spring.datasource.primary.password}")
    private String primaryDbPassword;
    @Value("${spring.datasource.primary.driver-class-name}")
    private String primaryDbDriverClassName;
    @Primary @Bean(name = "primaryDataSource")
    public DataSource primaryDataSource()
    {
        return DataSourceBuilder.create().url( primaryDbUrl ).username( primaryDbUsername )
                .password( primaryDbPassword ).driverClassName( primaryDbDriverClassName ).build();
    }

    @Primary @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory( EntityManagerFactoryBuilder builder,
                                                                               @Qualifier("primaryDataSource") DataSource primaryDataSource )
    {
        return builder.dataSource( primaryDataSource )
                .packages( "com.rks.student.studentcentraldb.entity" ).persistenceUnit( "primary" )
                .build();
    }

    @Primary @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager( @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory )
    {
        return new JpaTransactionManager( primaryEntityManagerFactory );
    }
}
