package referrer.service.endpoints.v1;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import referrer.service.Application;
import referrer.service.dto.v1.ReferrerUriDto;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestReferrerService {

	@Autowired
	private ReferrerResource resource;
	
	@Test
	public void testTrackReferrer() {
		ReferrerUriDto dto = new ReferrerUriDto();
		dto.setUri("http://www.google.com/something");
		Response response = resource.trackReferrer(dto);
		assertNotNull(response);
	}
	
}
