
package com.leysoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.dto.GreetingRequest;
import com.leysoft.dto.GreetingResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
        value = {
            "/greeting"
        })
public class GreetingController {

    @PostMapping
    @ApiOperation(
            value = "Greeting Operation",
            nickname = "greeting",
            httpMethod = "POST")
    @ApiResponses(
            value = {
                @ApiResponse(
                        code = 200,
                        message = "Success"),
                @ApiResponse(
                        code = 500,
                        message = "Server Error")
            })
    public GreetingResponse greeting(@ApiParam(
            name = "request",
            required = true,
            type = "GreetingRequest") @RequestBody GreetingRequest request) {
        GreetingResponse response = new GreetingResponse();
        response.setMessage("Hello " + request.getName());
        return response;
    }
}
