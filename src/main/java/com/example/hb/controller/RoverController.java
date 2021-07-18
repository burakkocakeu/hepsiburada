package com.example.hb.controller;

import com.example.hb.component.RedisComponent;
import com.example.hb.resource.RoverResource;
import com.example.hb.service.RoverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/deploy")
public class RoverController {

    private static final Logger LOGGER = LogManager.getLogger(RoverController.class);

    private RedisComponent redisComponent;
    private RoverService roverService;

    public RoverController(RoverService roverService, RedisComponent redisComponent) {
        this.roverService = roverService;
        this.redisComponent = redisComponent;
    }

    @GetMapping
    private String sayHelloWorld() {
        return "Hello World!";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> deploying(@RequestBody RoverResource roverResource) {
        try {
            LOGGER.info("Request received at " + new Date());

            //Thread.sleep(2000);
            redisComponent.save(roverResource);
            System.out.println(redisComponent.findById(roverResource.getBorders().getX().toString()));

            LOGGER.info("Request handled at " + new Date());
            return new ResponseEntity<>(roverService.moveAll(roverResource), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handle(HttpMessageNotReadableException e) {
        HashMap<String, String> err = new HashMap<>();
        err.put("Error", e.getCause().getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
