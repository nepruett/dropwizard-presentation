package com.blue_star_software;

import com.blue_star_software.health.TemplateHealthCheck;
import com.blue_star_software.resource.HelloNameResource;
import com.blue_star_software.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloApplication extends Application<HelloConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(HelloConfiguration configuration,
                    Environment environment) {

        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        environment.jersey().register(helloWorldResource);

        final HelloNameResource helloNameResource = new HelloNameResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(helloNameResource);
    }

}