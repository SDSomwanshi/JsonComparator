package com.test.JsonComparator.service.impl;

import com.test.JsonComparator.exception.EntityDoesNotFoundException;
import com.test.JsonComparator.exception.EntityIDCannotBePopulatedonCreate;
import com.test.JsonComparator.model.BaseJson;
import com.test.JsonComparator.repository.BaseJsonRepository;
import com.test.JsonComparator.service.BaseJsonService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
@Service
@Transactional
public class BaseJsonServiceImpl implements BaseJsonService {

    private BaseJsonRepository baseJsonRepository;

    public BaseJsonServiceImpl(BaseJsonRepository baseJsonRepository) {
        this.baseJsonRepository = baseJsonRepository;
    }

    @Override
    public List<BaseJson> getAllBaseJson() {
        return baseJsonRepository.findAll();
    }

    @Override
    public Optional<BaseJson> updateBaseJson(BaseJson baseJson) {
        Optional<BaseJson> baseJsonOptional = baseJsonRepository.findById(baseJson.getBaseJsonId());
        if(!baseJsonOptional.isPresent()) {
            throw new EntityDoesNotFoundException();
        }
        BaseJson baseJsonObject = baseJsonRepository.save(baseJson);
        return Optional.of(baseJsonObject);
    }

    @Override
    public Optional<BaseJson> getBaseJson(Long id) {
        return baseJsonRepository.findById(id);
    }

    @Override
    public Optional<BaseJson> createBaseJson(BaseJson baseJson) {
        if(StringUtils.isEmpty(baseJson.getBaseJsonId())) {
            throw new EntityIDCannotBePopulatedonCreate();
        }
        return Optional.of(baseJsonRepository.save(baseJson));
    }

    @Override
    public void deleteBaseJson(Long id) {
        Optional<BaseJson> baseJson = baseJsonRepository.findById(id);
        baseJson.ifPresent(baseJsonRepository :: delete);
    }
}
