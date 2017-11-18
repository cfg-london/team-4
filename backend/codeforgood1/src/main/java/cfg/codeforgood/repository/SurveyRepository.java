package cfg.codeforgood.repository;

import cfg.codeforgood.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("select distinct c.country from Survey c")
    List<String> findAllDistinctCountries();


}
