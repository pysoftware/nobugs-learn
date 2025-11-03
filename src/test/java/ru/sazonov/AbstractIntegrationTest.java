package ru.sazonov;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public abstract class AbstractIntegrationTest {
    @Container
    static GenericContainer<?> api = new GenericContainer<>(DockerImageName.parse("nobugsme/nbank:latest"))
            .withExposedPorts(Integer.valueOf(System.getProperty("server.app.port")));

    @BeforeAll
    public static void beforeAll() {
        ApiSpecifications.PORT = api.getMappedPort(Integer.parseInt(System.getProperty("server.app.port")));
    }
}
