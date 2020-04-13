package com.test.JsonComparator.controller;

import com.test.JsonComparator.model.BaseJson;
import com.test.JsonComparator.service.CompareJsonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@RestController
@Api(value = "this api is to compare Json")
@RequestMapping(value = CompareJsonController.BASE_URL)
public class CompareJsonController {
    static final String BASE_URL = "/api/v1/compare-json";

    private CompareJsonService compareJsonService;

    @Autowired
    public CompareJsonController(CompareJsonService compareJsonService) {
        this.compareJsonService = compareJsonService;
    }

    @PostMapping(value = "/")
    @ApiOperation(value = "this api is to compare two JSONs")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = CompareJsonController.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public String compareJson(@RequestBody BaseJson baseJson) {
        String desiredJson = null;
        try {
            desiredJson = compareJsonService.compareJsons(baseJson);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return desiredJson;
    }

}
