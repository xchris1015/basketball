package io.chris.training.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "io.chris.training.repository")
public class DataSourceConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String driverClassName ="org.postgresql.ds.PGSimpleDataSource";
    private String databaseUrl ="jdbc:postgresql://localhost:5432/basketball";
    private String databaseUsername = "admin";
    private String databasePassword = "password";



    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[] { "io.chris.training.domain","io.chris.training.repository" });
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        props.put("hibernate.hbm2ddl.auto", "validate");// fine all the stuff in domain and entity and table then scan instance variables
//        props.put("hibernate.physical_naming_strategy", "com.overture.family.extend.hibernate.ImprovedNamingStrategy")
        props.put("hibernate.connection.charSet","UTF-8");
        props.put("hibernate.show_sql","true");
//        props.put("")


//            <property name="hibernate.ejb.interceptor" value="com.overture.family.repository.jpa.DBNullsFirstLastInteceptor"/>

        factoryBean.setJpaProperties(props);

        return factoryBean;
    }



    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory, @Autowired DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        logger.debug("create datasource");
        logger.info("test");
        logger.warn("warn test");
        logger.error("error test");
        return dataSource;
    }

    private BasicDataSource createDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName); // current class instance variables
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(180000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(180000);
        return dataSource;
    }
}
