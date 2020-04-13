package com.test.JsonComparator.service;


import com.test.JsonComparator.model.BaseJson;

import java.util.List;
import java.util.Optional;
/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
public interface BaseJsonService {
    List<BaseJson> getAllBaseJson();
    Optional<BaseJson> updateBaseJson(BaseJson baseJson);
    Optional<BaseJson> getBaseJson(Long id);
    Optional<BaseJson> createBaseJson(BaseJson baseJson);
    void deleteBaseJson(Long id);
}
