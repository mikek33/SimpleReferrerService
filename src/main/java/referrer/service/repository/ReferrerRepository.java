package referrer.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import referrer.service.entity.ReferrerEntity;

/**
 * Repository class for Referrer entity.
 * @author michaelkent
 *
 */
@Repository
public interface ReferrerRepository extends PagingAndSortingRepository<ReferrerEntity, Long> {
	
	Page<ReferrerEntity> findAllByOrderByTotalCountDesc(Pageable pageable);

	ReferrerEntity findByHost(String host);
	
}
