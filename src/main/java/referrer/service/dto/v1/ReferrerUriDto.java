package referrer.service.dto.v1;

/**
 * Request to save or update a referrer from the source uri.
 * @author michaelkent
 *
 */
public class ReferrerUriDto {

	private String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
