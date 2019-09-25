package co.com.devco.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {
    /*@Bean
    public DataSource dataSource()
    {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        DataSource dataSource = dataSourceLookup.getDataSource("java:/jdbc/datasources/secretsDS");
        return dataSource;
    }*/
}
