package referrer.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import referrer.service.dao.ReferrerDao;
import referrer.service.dto.v1.UriHostDto;
import referrer.service.entity.ReferrerEntity;

/**
 * Delegate for Referrer resource.
 * @author michaelkent
 *
 */
@Component
public class ReferrerDelegate {

	@Autowired
	private ReferrerDao referrerDao;
	
	/**
	 * Assemble the top N referrers.
	 * @param numRecs
	 * @return
	 */
	public List<UriHostDto> getTopReferrerHosts(int numRecs) {
		List<ReferrerEntity> entities = referrerDao.findTopRecords(numRecs);
		List<UriHostDto> domains = new ArrayList<>();
		for(ReferrerEntity entity : entities) {
			UriHostDto domain = new UriHostDto();
			domain.setHost(entity.getHost());
			domain.setTotalTracked(entity.getTotalCount());
			domains.add(domain);
		}
		return domains;
	}
	
	/**
	 * Save or update the count of a referrer.
	 * @param uri
	 * @return
	 */
	public boolean trackReferrer(String uri) {
		ReferrerUri referrerUri = new ReferrerUri(uri);

		if (referrerUri.isValidUri()) {
			ReferrerEntity entity = referrerDao.findByHost(referrerUri.getHost());
			if (entity == null) {
				entity = new ReferrerEntity();
				entity.setHost(referrerUri.getHost());
				entity.setTotalCount(0);
			}
			entity.setTotalCount(entity.getTotalCount() + 1);
			referrerDao.save(entity);
		}
		return referrerUri.isValidUri();
	}

}
