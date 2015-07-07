package com.blue_star_software.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Message message = new Message(1, "Hello, TestName");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/com/example/api/Message.json"), Message.class));

        assertThat(MAPPER.writeValueAsString(message)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final Message message = new Message(1, "Hello, TestName");
        assertThat(MAPPER.readValue(fixture("fixtures/com/example/api/Message.json"), Message.class))
                .isEqualTo(message);
    }
}
