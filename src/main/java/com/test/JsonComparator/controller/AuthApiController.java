package com.test.JsonComparator.controller;

import com.test.JsonComparator.model.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@Api("Authentication")
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthApiController {
    @ApiOperation(value = "Login", notes = "Login with the given credentials.")
    @ApiResponses({@ApiResponse(code = 200, message = "", response = Authentication.class)})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody Auth auth) {
        throw new IllegalStateException("Add Spring Security to handle authentication");
    }
}
