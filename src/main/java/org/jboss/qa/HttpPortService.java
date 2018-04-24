package org.jboss.qa;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

public class HttpPortService implements Service<Integer> {
    private Integer port;

    @Override
    public void start(StartContext context) throws StartException {
        System.out.println("HttpPortService start");
        port = 80;
    }

    @Override
    public void stop(StopContext context) {
        System.out.println("HttpPortService stop");
        port = null;
    }

    @Override
    public Integer getValue() throws IllegalStateException, IllegalArgumentException {
        return port;
    }
}
