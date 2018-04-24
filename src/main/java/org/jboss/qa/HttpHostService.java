package org.jboss.qa;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

public class HttpHostService implements Service<String> {
    public String httpHost;

    @Override
    public void start(StartContext context) throws StartException {
        System.out.println("HttpHostService start");
        httpHost = "test";
    }

    @Override
    public void stop(StopContext context) {
        System.out.println("HttpHostService stop");
        httpHost = null;
    }

    @Override
    public String getValue() throws IllegalStateException, IllegalArgumentException {
        return httpHost;
    }
}
