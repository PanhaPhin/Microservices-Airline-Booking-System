package com.panha.Controller;

import com.panha.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ApiResponse HomeController(){
        ApiResponse apiResponse= new ApiResponse("hay everyone !");
        return apiResponse;

    }

}
