package referrer.service.dto.v1;

/**
 * Error Message that can be conveyed back to the caller.
 * @author michaelkent
 *
 */
public class ErrMessage {
	public String message;

	public ErrMessage() {

	}

	public ErrMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
