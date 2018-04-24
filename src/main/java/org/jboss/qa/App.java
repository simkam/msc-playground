package org.jboss.qa;

import org.jboss.msc.service.ServiceBuilder;
import org.jboss.msc.service.ServiceContainer;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StabilityMonitor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServiceName httpServerServiceName = ServiceName.of("http", "server");
        ServiceName httpHostServiceName = ServiceName.of("http", "host");
        ServiceName httpPortServiceName = ServiceName.of("http", "port");

        ServiceContainer container = ServiceContainer.Factory.create("container", true);
        container.awaitStability();

        StabilityMonitor monitor = new StabilityMonitor();

        HttpServerService httpServerService = new HttpServerService();
        ServiceBuilder<HttpServerService> httpServerServiceBuilder = container.addService(httpServerServiceName, httpServerService);
        httpServerServiceBuilder.addMonitor(monitor);
        httpServerServiceBuilder.addDependency(httpHostServiceName, String.class, httpServerService.getHttpHostInjector());
        httpServerServiceBuilder.addDependency(httpPortServiceName, Integer.class, httpServerService.getHttpPortInjector());
        httpServerServiceBuilder.install();

        monitor.awaitStability();

        HttpHostService httpHostService = new HttpHostService();
        ServiceBuilder<String> httpHostServiceBuilder = container.addService(httpHostServiceName, httpHostService);
        httpHostServiceBuilder.addMonitor(monitor);
        httpHostServiceBuilder.install();

        monitor.awaitStability();

        HttpPortService httpPortService = new HttpPortService();
        ServiceBuilder<Integer> httpPortServiceBuilder = container.addService(httpPortServiceName, httpPortService);
        httpPortServiceBuilder.addMonitor(monitor);
        httpPortServiceBuilder.install();

        monitor.awaitStability();

        container.shutdown();
        container.awaitTermination();
    }

}
