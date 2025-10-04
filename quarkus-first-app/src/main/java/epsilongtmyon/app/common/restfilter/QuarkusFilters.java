package epsilongtmyon.app.common.restfilter;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

// quarkus方式

public class QuarkusFilters {
	
	@Inject
	Logger logger;
	
	
	// 引数や戻り値は@ServerRequestFilterのjavadoc参照

    @ServerRequestFilter
    public void preMatchingFilter(ContainerRequestContext requestContext) {
        
    	String url = requestContext.getUriInfo().getAbsolutePath().toString();
    	logger.info(url);
    }
}
