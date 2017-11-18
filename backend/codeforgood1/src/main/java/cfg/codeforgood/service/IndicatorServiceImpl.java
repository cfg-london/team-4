package cfg.codeforgood.service;

import cfg.codeforgood.entity.Indicator;
import cfg.codeforgood.repository.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicatorServiceImpl implements IndicatorsServiceItf{

    private IndicatorRepository indicatorRepository;

    @Autowired
    public IndicatorServiceImpl(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    @Override
    public List<Indicator> getAll() {
        return indicatorRepository.findAll();
    }

    @Override
    public List<String> getDistinctCategories() {
        return indicatorRepository.findDistinctCategories();
    }
}
