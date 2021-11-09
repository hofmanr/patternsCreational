package com.pluralsight.factory2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.Set;

/* see: https://docs.jboss.org/weld/reference/2.4.0.CR1/en-US/html/injection.html#_obtaining_a_contextual_instance_by_programmatic_lookup*/
@Dependent
public class WebsiteFactory2 {
    private static Logger LOGGER = LoggerFactory.getLogger(WebsiteFactory2.class);

    @Inject
    private BeanManager beanManager;

    @Inject @Any
    Instance<Website> websites;

    private Instance<Website> bean;

    public Website getInstance(WebsiteType siteType) {
        Annotation qualifier = new SiteAnnotationLiteral(siteType);
        bean = websites.select(qualifier);
        if (!bean.isAmbiguous() && !bean.isUnsatisfied()) {
            return bean.get();
        }
        return null;
    }

    public void destroy(Website website) {
        LOGGER.info("Destroy...");
        bean.destroy(website);
    }

    /**
     * see: https://blog.akquinet.de/2017/01/04/dont-get-trapped-into-a-memory-leak-using-cdi-instance-injection/
     * Using #destroy() Method with CDI 1.1 to prevent memory leak
     */
    public void executeLeakFixedCDI11(final WebsiteType siteType) {
        Annotation qualifier = new SiteAnnotationLiteral(siteType);
        Instance<Website> bean = websites.select(qualifier);
        Website website = bean.get();
        LOGGER.info(website.getPages().toString());
        bean.destroy(website);
    }

    /**
     * CDI 1.0 to correctly doing CDI resource management
     * @param siteType
     */
    public void executeLeakFixedCDI10(final WebsiteType siteType) {
        Annotation qualifier = new SiteAnnotationLiteral(siteType);
        Set<Bean<?>> beans = beanManager.getBeans(Website.class, qualifier);
        Bean<Website> bean = (Bean<Website>) beans.iterator().next();

        CreationalContext<?> creationalContext = beanManager.createCreationalContext( bean );
        Website website = (Website) beanManager.getReference( bean, Website.class, creationalContext);

        LOGGER.info(website.getPages().toString());

        creationalContext.release();
    }

}
