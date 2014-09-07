package org.test;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SimpleDbConfig {

	@Bean
	public DataSource dataSource() {
		
		URI dbUri;
        try {
        	String username = "postgres";
            String password = "R66velRonja";
            String url = "jdbc:postgresql://localhost:5432/esi_database";
            String dbProperty = System.getenv("postgres://gfpczuckdxlwjl:cQCUgORXxhiLGZKfh6KoMsA7BY@ec2-54-204-24-154.compute-1.amazonaws.com:5432/d4mj8ubqkcnbkr");
            if(dbProperty != null) {
                dbUri = new URI(dbProperty);

                username = dbUri.getUserInfo().split(":")[0];
                password = dbUri.getUserInfo().split(":")[1];
                url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            }     

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            return basicDataSource;

        } catch (URISyntaxException e) {
            return null;
        }
	}
}
