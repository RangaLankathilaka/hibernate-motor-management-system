package lk.ijse.motor.main;



import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("file:${user.dir}/Motor/resource/application.properties")
@EnableTransactionManagement
public class HibernateConfig{
    @Autowired
    private Environment environment;
    

@Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(environment.getRequiredProperty("hibernate.connection.driver_class"));
        basicDataSource.setUrl(environment.getRequiredProperty("hibernate.connection.url"));
        basicDataSource.setUsername(environment.getRequiredProperty("hibernate.connection.username"));
        basicDataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));

        basicDataSource.setMaxTotal(environment.getRequiredProperty("hibernate.max_total",Integer.class));
        basicDataSource.setInitialSize(environment.getRequiredProperty("hibernate.initial_size", Integer.class));
        basicDataSource.setMaxIdle(environment.getRequiredProperty("hibernate.max_idle", Integer.class));

        return basicDataSource;



    }


    public Properties properties(){

        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        return properties;


    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sf){

    return new HibernateTransactionManager(sf);


    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("lk.ijse.motor.entity");
        localSessionFactoryBean.setHibernateProperties(properties());


        return localSessionFactoryBean;

    }









}