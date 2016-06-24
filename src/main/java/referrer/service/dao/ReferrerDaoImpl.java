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

@Component
public class ReferrerDaoImpl implements ReferrerDao {

	@Autowired
	private ReferrerRepository referrerRepository;

	@Override
	@Transactional(readOnly = true)
    public List<ReferrerEntity> findTopRecords(int numRecs) {
		Pageable pageable = new PageRequest(0, numRecs);
        Page<ReferrerEntity> page = referrerRepository.findAllByOrderByTotalCountDesc(pageable);
        return page.getContent();
    }
	
	@Override
	@Transactional
    public void save(ReferrerEntity entity) {
        referrerRepository.save(entity);
    }

	@Override
	public ReferrerEntity findByHost(String host) {
		return referrerRepository.findByHost(host);
	}
	
}
