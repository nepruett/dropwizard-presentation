package com.blue_star_software.resources;

import com.blue_star_software.api.Message;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloNameResourceTest {

    @Rule
    public ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloNameResource("Hello, %s", "DefaultUser"))
            .build();

    @Test
    public void testDefaultName() {
        final Message defaultMessage = new Message(1, "Hello, DefaultUser");
        assertThat(resources.client().target("/hello").request().get(Message.class))
                .isEqualTo(defaultMessage);
    }

    @Test
    public void testSpecifiedName() {
        final Message message = new Message(1, "Hello, SpecifiedUser");
        assertThat(resources.client().target("/hello?name=SpecifiedUser").request().get(Message.class))
                .isEqualTo(message);
    }
}
