package me.nolanjames.woodkin.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration(proxyBeanMethods = false)
@Profile("h2-tcp")
public class H2TcpServerConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2TcpServer(@Value("${app.h2.tcp.port:9092}") int port) throws SQLException {
        return Server.createTcpServer("-tcpPort", Integer.toString(port), "-ifExists");
    }
}