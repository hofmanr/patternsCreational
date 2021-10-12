package com.pluralsight;

import com.pluralsight.factory.App;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class MainApp
{
    static {
        System.setProperty("org.jboss.logging.provider", "slf4j");
    }

    public static void main( String[] args )
    {
        // Without known implementation
        SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
        try (SeContainer container = containerInit.initialize()) {
            // Fire synchronous event that triggers the code in App class.
            // container.getBeanManager().fireEvent(new SimpleEvent());

            container.select(App.class).get().run();
        }

        // OR with implementation
//        Weld weld = new Weld();
//        try (WeldContainer weldContainer = weld.initialize()) {
//            weldContainer.select(App.class).get().run();
//        }

    }
}
