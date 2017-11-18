package cfg.codeforgood.repository;

import cfg.codeforgood.entity.AgeGroup;
import cfg.codeforgood.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("select distinct c.country from Survey c")
    List<String> findAllDistinctCountries();

    @Query("select c from Survey c where c.country = :country")
    List<Survey> findAgesByCountry(@Param("country")String country);
}
