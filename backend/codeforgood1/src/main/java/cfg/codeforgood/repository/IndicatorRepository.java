package cfg.codeforgood.repository;

import cfg.codeforgood.entity.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, Long> {

    @Query("select distinct c.name from Indicator c")
    List<String> findDistinctCategories();

    @Query("select c from Indicator c where c.type = :type")
    List<Indicator> findIndiByType(@Param("type") String type);
}
