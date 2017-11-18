package cfg.codeforgood.service;

import cfg.codeforgood.entity.AgeGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgeGroupServiceItf {

    List<AgeGroup> getAll();

}
