package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static driver.DriverFactory.*;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        createWebDriverManager();
    }

    @BeforeEach
    void init() {
        getDriver();
    }

    @AfterEach
    void teardown() {
        cleanUp();
    }
}
