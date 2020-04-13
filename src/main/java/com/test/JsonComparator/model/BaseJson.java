package com.test.JsonComparator.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@Entity
@Table(name="base_json")
public class BaseJson implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long baseJsonId;

    @Column(name = "json_text")
    @Type(type="text")
    private String inputJson;

    public Long getBaseJsonId() {
        return baseJsonId;
    }

    public void setBaseJsonId(Long baseJsonId) {
        this.baseJsonId = baseJsonId;
    }

    public String getInputJson() {
        return inputJson;
    }

    public void setInputJson(String inputJson) {
        this.inputJson = inputJson;
    }


    @Override
    public String toString() {
        return "JsonCompare{" +
                "baseJsonId=" + baseJsonId +
                ", inputJson='" + inputJson + '\'' +
                '}';
    }
}
