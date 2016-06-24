package referrer.service.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestReferrerUri {

	@Test
	public void testValidUri() {
		ReferrerUri uri = new ReferrerUri("http://www.google.com/");
		assertTrue(uri.isValidUri());
	}
	
	@Test
	public void testInvalidUri() {
		ReferrerUri uri = new ReferrerUri("google.com/");
		assertFalse(uri.isValidUri());
	}
	
	@Test
	public void testEmptyUri() {
		ReferrerUri uri = new ReferrerUri("");
		assertFalse(uri.isValidUri());
	}
}
