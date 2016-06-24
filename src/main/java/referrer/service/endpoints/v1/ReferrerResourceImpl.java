package referrer.service.endpoints.v1;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import referrer.service.domain.ReferrerDelegate;
import referrer.service.dto.v1.ErrMessage;
import referrer.service.dto.v1.ReferrerUriDto;
import referrer.service.dto.v1.UriHostDto;

@Service
public class ReferrerResourceImpl implements ReferrerResource {

	private static final Logger logger = LoggerFactory.getLogger(ReferrerResource.class);

	@Autowired
	private ReferrerDelegate referrerDelegate;

	@Override
	public Response trackReferrer(ReferrerUriDto request) {
		boolean validUri = referrerDelegate.trackReferrer(request.getUri());
		Response response = null;
		if (validUri) {
			response = Response.ok().build();
		} else {
			response = Response.status(Status.PRECONDITION_FAILED).entity(new ErrMessage("Invalid URI.")).build();
		}
		return response;
	}

	@Override
	public Response getTopReferrerHosts(int numRecs) {
		List<UriHostDto> list = referrerDelegate.getTopReferrerHosts(numRecs);
		return Response.ok().entity(list).build();
	}

}
