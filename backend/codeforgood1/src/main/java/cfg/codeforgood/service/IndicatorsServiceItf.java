package cfg.codeforgood.service;

import cfg.codeforgood.entity.Indicator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndicatorsServiceItf {

    List<Indicator> getAll();
}
