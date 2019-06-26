package com.example.carmanagement.config.db;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;

/**
 * author by davitpetrosyan on 2019-05-05.
 */
@Configuration
public class DBConnectionConfig {

	@Bean
	PostgresqlConnectionFactory connectionFactory(
			@Value("${db.host}") String host,
			@Value("${db.port}") Integer port,
			@Value("${db.databasename}") String databasename,
			@Value("${db.username}") String username,
			@Value("${db.password}") String password) {
		return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
				.host(host)
				.port(port)
				.database(databasename)
				.username(username)
				.password(password).build());
	}


	@Bean
	DatabaseClient databaseClient(PostgresqlConnectionFactory connectionFactory) {
		return DatabaseClient.create(connectionFactory);
	}
}
