package aplicacao.configuracoes;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement 
@EnableJpaRepositories(basePackages =  "aplicacao.model.repositories")
public class ConfiguracoesBD {
	
	@Bean
	public ComboPooledDataSource dataSource() throws IllegalStateException, PropertyVetoException{
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/CRUD");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		return dataSource;
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("aplicacao.modelo.entidades");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		
		Properties jpaProperties = new Properties(); //proterties 
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "create");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return entityManagerFactoryBean;
		
	}
	
	@Bean
	public JpaTransactionManager transactionManager() throws Exception{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return null;
		
	}
	
	

}
