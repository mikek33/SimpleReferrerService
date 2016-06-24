package referrer.service.dto.v1;

/**
 * Transfer object that contains the domain from the referrer and total number of times
 * it's been tracked.
 * @author michaelkent
 *
 */
public class UriHostDto extends ErrMessage {

	private String host;
	private Integer totalTracked;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getTotalTracked() {
		return totalTracked;
	}

	public void setTotalTracked(Integer totalTracked) {
		this.totalTracked = totalTracked;
	}

}
