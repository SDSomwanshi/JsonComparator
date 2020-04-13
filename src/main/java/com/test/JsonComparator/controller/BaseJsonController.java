package com.test.JsonComparator.controller;

import com.test.JsonComparator.model.BaseJson;
import com.test.JsonComparator.service.BaseJsonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@RestController
@Api(value = "this api is to maintain base Json")
@RequestMapping(value = BaseJsonController.BASE_URL)
public class BaseJsonController {
    static final String BASE_URL = "/api/v1/base-json";

    private BaseJsonService baseJsonService;

    @Autowired
    public BaseJsonController(BaseJsonService baseJsonService) {
        this.baseJsonService = baseJsonService;
    }

    @GetMapping(value = "/")
    @ApiOperation(value = "this api is to get all base-json")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = BaseJson.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public List<BaseJson> getAllBaseJson() {
        return baseJsonService.getAllBaseJson();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "this api is to fetch base-json by Id")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = BaseJson.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public Optional<BaseJson> getBaseJson(@PathVariable Long id) {
         return baseJsonService.getBaseJson(id);
    }

    @PostMapping(value = "/")
    @ApiOperation(value = "this api is to create base-json")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = BaseJson.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public Optional<BaseJson> createBaseJson(@RequestBody BaseJson baseJson) {
        return baseJsonService.createBaseJson(baseJson);
    }

    @PutMapping(value = "/")
    @ApiOperation(value = "this api is to update existing base-json")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = BaseJson.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public Optional<BaseJson> updateBaseJson(@RequestBody BaseJson baseJson) {
        return baseJsonService.updateBaseJson(baseJson);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "this api is to delete existing base-json")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accepted", response = BaseJson.class),
    @ApiResponse(code = 404, message = "Not Found"),
    @ApiResponse(code = 500, message = "Server Failure"),
    @ApiResponse(code = 400, message = "Bad Request")})
    public void deleteBaseJson(@PathVariable Long id) {
        baseJsonService.deleteBaseJson(id);
    }
}
