package me.nolanjames.woodkin;

import org.h2.tools.Server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = "app.h2.tcp.port=0")
@ActiveProfiles("h2-tcp")
class H2TcpServerIntegrationTests {

    @Autowired
    private Server h2TcpServer;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void tcpConnectionSeesTheApplicationProducts() throws Exception {
        int embeddedProductCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products", Integer.class);
        String url = "jdbc:h2:tcp://localhost:" + h2TcpServer.getPort() + "/mem:woodkin";

        try (var connection = DriverManager.getConnection(url, "sa", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM products")) {
            assertTrue(resultSet.next());
            assertEquals(embeddedProductCount, resultSet.getInt(1));
            assertTrue(embeddedProductCount > 0);
        }
    }
}