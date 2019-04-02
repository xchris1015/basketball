package io.chris.training.core.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "io.chris.training.core.repository")
public class DataSourceConfig {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("#{applicationProperties['database.dataSourceClassName']}")
    private String driverClassName;

    @Value("${db.url}")
    private String databaseUrl;

    @Value("${db.username}")
    private String databaseUsername;

    @Value("${db.password}")
    private String databasePassword;



    @Bean(name="entityManagerFactory")
//    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[] { "io.chris.training.core.domain","io.chris.training.core.repository" });
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        props.put("hibernate.temp.use_jdbc_metadata_defaults","false");
        props.put("hibernate.hbm2ddl.auto", "validate");// fine all the stuff in domain and entity and table then scan instance variables
//        props.put("hibernate.physical_naming_strategy", "com.overture.family.extend.hibernate.ImprovedNamingStrategy")
        props.put("hibernate.connection.charSet","UTF-8");
        props.put("hibernate.show_sql","false"); // this is the only change on method on unit
//        props.put("")


//            <property name="hibernate.ejb.interceptor" value="com.overture.family.repository.jpa.DBNullsFirstLastInteceptor"/>

        factoryBean.setJpaProperties(props);

        return factoryBean;
    }

//    @Bean(name="entityManagerFactory")
////    @DependsOn("flyway")
//    public LocalContainerEntityManagerFactoryBean entityUnitManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        factoryBean.setDataSource(getDataSource());
//        factoryBean.setPackagesToScan(new String[] { "io.chris.training.core.domain","io.chris.training.core.repository" });
//        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        Properties props = new Properties();
//        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
//        props.put("hibernate.temp.use_jdbc_metadata_defaults","false");
//        props.put("hibernate.hbm2ddl.auto", "validate");// fine all the stuff in domain and entity and table then scan instance variables
////        props.put("hibernate.physical_naming_strategy", "com.overture.family.extend.hibernate.ImprovedNamingStrategy")
//        props.put("hibernate.connection.charSet","UTF-8");
//        props.put("hibernate.show_sql","true");
////        props.put("")
//
//
////            <property name="hibernate.ejb.interceptor" value="com.overture.family.repository.jpa.DBNullsFirstLastInteceptor"/>
//
//        factoryBean.setJpaProperties(props);
//
//        return factoryBean;
//    }



    @Bean(name="transactionManager") //check all the annotation with entity, this is for roll back on transactional
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory, @Autowired DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        return dataSource;
    }

    private BasicDataSource createDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName); // current class instance variables
        dataSource.setUrl("jdbc:postgresql://"+databaseUrl);
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
