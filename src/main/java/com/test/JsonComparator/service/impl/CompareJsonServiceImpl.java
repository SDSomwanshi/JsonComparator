package com.test.JsonComparator.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.test.JsonComparator.exception.EntityDoesNotFoundException;
import com.test.JsonComparator.exception.InvalidJsonException;
import com.test.JsonComparator.model.BaseJson;
import com.test.JsonComparator.repository.BaseJsonRepository;
import com.test.JsonComparator.service.CompareJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
@Service
@Transactional
public class CompareJsonServiceImpl implements CompareJsonService {

    private final BaseJsonRepository baseJsonRepository;

    @Autowired
    public CompareJsonServiceImpl(BaseJsonRepository baseJsonRepository) {
        this.baseJsonRepository = baseJsonRepository;
    }

    public String compareJsons(BaseJson baseJson)  {

        Optional<BaseJson> baseJsonOptional = baseJsonRepository.findById(baseJson.getBaseJsonId());
        if(!baseJsonOptional.isPresent()) {
            throw new EntityDoesNotFoundException();
        }

        ObjectMapper jackson = new ObjectMapper();
        JsonNode baseJsonNode = null;
        JsonNode inputJsonNode = null;
        JsonNode patchNode = null;
        try {
            baseJsonNode = jackson.readTree(baseJsonOptional.get().getInputJson());
            inputJsonNode = jackson.readTree(baseJson.getInputJson());
            patchNode = JsonDiff.asJson(baseJsonNode, inputJsonNode);
        }catch(Exception e) {
            throw new InvalidJsonException();
        }
        String difference="";
        for(int i=0; i<patchNode.size(); i++) {
            String path = patchNode.get(i).get("path").textValue();
            int index = Integer.parseInt(path.split("/")[2]);
            String root = path.split("/")[1];
            difference += inputJsonNode.get(root).get(index).get("name")+":"+patchNode.get(i).get("value")+",";
        }
        return "{"+difference.substring(0,difference.length()-1)+"}";
    }


}
