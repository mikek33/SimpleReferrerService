package referrer.service.domain;

import java.net.URI;
import java.net.URISyntaxException;

import org.h2.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles getting the domain from the source referrer uri.
 * @author michaelkent
 *
 */
public class ReferrerUri {
	
	private static final Logger logger = LoggerFactory.getLogger(ReferrerUri.class);

	private String host;
	private boolean validUri;
	
	public ReferrerUri(String sourceUri) {
		try {
			URI uri = new URI(sourceUri);
			host = uri.getHost();
			validUri = !StringUtils.isNullOrEmpty(host);
		} catch (URISyntaxException e) {
			logger.error("Unable to process sourceUri {}", sourceUri, e);
		}
		logger.debug("ValidUri {}", validUri);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public boolean isValidUri() {
		return validUri;
	}

	public void setValidUri(boolean validUri) {
		this.validUri = validUri;
	}

	
}
