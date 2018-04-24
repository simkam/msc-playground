package org.jboss.qa;

import org.jboss.msc.inject.Injector;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.jboss.msc.value.InjectedValue;

public class HttpServerService implements Service<HttpServerService> {

    private final InjectedValue<String> httpHost = new InjectedValue<>();
    private final InjectedValue<Integer> httpPort = new InjectedValue<>();

    public HttpServerService() {
        //
    }

    public void start(StartContext context) throws StartException {
        System.out.println("HttpServerService start");

    }

    public void stop(StopContext context) {
        System.out.println("HttpServerService stop");
    }

    public HttpServerService getValue() throws IllegalStateException, IllegalArgumentException {
        return this;
    }

    public Injector<String> getHttpHostInjector() {
        return httpHost;
    }

    public Injector<Integer> getHttpPortInjector() {
        return httpPort;
    }
}
