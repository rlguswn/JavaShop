package rlguswn.JavaShop.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class SQLiteForeignKeyEnabler {

    private static final Logger logger = LoggerFactory.getLogger(SQLiteForeignKeyEnabler.class);

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void enableForeignKeys() {
        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");
        } catch (Exception e) {
            logger.error("Failed to enable foreign keys for SQLite", e);
        }
    }
}
