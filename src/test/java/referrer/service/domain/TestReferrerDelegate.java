package referrer.service.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import referrer.service.dao.ReferrerDao;
import referrer.service.dto.v1.UriHostDto;
import referrer.service.entity.ReferrerEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestReferrerDelegate {

	@Mock
	private ReferrerDao referrerDao;
	@InjectMocks
	private ReferrerDelegate delegate;
	private List<ReferrerEntity> mockList = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReferrerEntity entity = new ReferrerEntity();
		entity.setHost("google.com");
		entity.setTotalCount(3);
		mockList.add(entity);

	}

	@Test
	public void testReferrerDelegateValidUri() {
		when(referrerDao.findTopRecords(anyInt())).thenReturn(mockList);
		List<UriHostDto> domains = delegate.getTopReferrerHosts(3);
		assertEquals(1, domains.size());
		assertEquals("google.com", domains.get(0).getHost());
		assertEquals(Integer.valueOf(3), domains.get(0).getTotalTracked());
	}
	
	@Test
	public void testTrackDomain() {
		ReferrerEntity entity = new ReferrerEntity();
		entity.setHost("google.com");
		entity.setTotalCount(5);
		
		when(referrerDao.findByHost(any(String.class))).thenReturn(entity);
		doNothing().when(referrerDao).save(any(ReferrerEntity.class));
		boolean valid = delegate.trackReferrer("http://www.google.com");
		assertTrue(valid);
	}
}
