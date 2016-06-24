package referrer.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import referrer.service.entity.ReferrerEntity;
import referrer.service.repository.ReferrerRepository;

/**
 * Data access for Referrer entity.
 * @author michaelkent
 *
 */
@Component
public interface ReferrerDao {

	/**
	 * Find the top N number of records.
	 * @param numRecs
	 * @return
	 */
	@Transactional(readOnly = true)
    public List<ReferrerEntity> findTopRecords(int numRecs);
	
	/**
	 * Save a referrer object.
	 * @param entity
	 */
	@Transactional
    public void save(ReferrerEntity entity);

	/**
	 * Find a referrer by domain.
	 * @param domain
	 * @return
	 */
	public ReferrerEntity findByHost(String host);
	
}
