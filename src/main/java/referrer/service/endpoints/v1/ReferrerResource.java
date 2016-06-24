package referrer.service.endpoints.v1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import referrer.service.dto.v1.ReferrerUriDto;

/**
 * Rest resource for handling incoming referrer related requests.
 * @author michaelkent
 *
 */
@Path("/service")
public interface ReferrerResource {
	
	/**
	 * Gets the top referrer hosts by count.
	 * @param numResults The number of results to return
	 * @return The 
	 */
	@GET
    @Path("/v1/topreferrers/{numResults}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getTopReferrerHosts(@PathParam("numResults") int numResults);

	/**
	 * Takes in incoming uri and saves the domain
	 * @param request
	 * @return
	 */
	@POST
    @Path("/v1/track/referrer")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    public Response trackReferrer(ReferrerUriDto request);
	

}
