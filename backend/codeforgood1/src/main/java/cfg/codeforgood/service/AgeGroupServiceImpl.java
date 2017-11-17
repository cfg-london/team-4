package cfg.codeforgood.service;

import cfg.codeforgood.entity.AgeGroup;
import cfg.codeforgood.repository.AgeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeGroupServiceImpl implements AgeGroupServiceItf {
    private AgeGroupRepository ageGroupRepository;

    @Autowired
    public AgeGroupServiceImpl(AgeGroupRepository ageGroupRepository) {
        this.ageGroupRepository = ageGroupRepository;
    }

    public List<AgeGroup> getAll() {
        return ageGroupRepository.findAll();
    }
}
