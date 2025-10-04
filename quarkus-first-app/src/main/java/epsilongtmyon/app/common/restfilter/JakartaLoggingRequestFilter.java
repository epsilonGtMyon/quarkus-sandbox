package epsilongtmyon.app.common.restfilter;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

// jakarta REST 方式

@Provider
public class JakartaLoggingRequestFilter implements ContainerRequestFilter {

	@Inject
	Logger logger;
	
    @Override
    public void filter(ContainerRequestContext requestContext) {
    	String url = requestContext.getUriInfo().getAbsolutePath().toString();
    	logger.info(url);
    }
}
