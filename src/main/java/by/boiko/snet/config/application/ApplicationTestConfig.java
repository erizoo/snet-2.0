package by.boiko.snet.config.application;

import by.boiko.snet.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("by.boiko.snet.config.repository")
@PropertySource(value = {"classpath:hibernate.properties"})
@ComponentScan(basePackageClasses = {User.class})
public class ApplicationTestConfig {

    @Autowired
    private Environment environment;

//    @Bean
//    public DataSource dataSource() throws SQLException {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriver(new Driver());
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("JAWSDB_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException, URISyntaxException {  //TODO убрать
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("by.boiko.snet.model");
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws SQLException, URISyntaxException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("by.boiko.snet.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

//    @Bean
//    public JpaTransactionManager transactionManager() throws SQLException {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
//        return jpaTransactionManager;
//    }

}
