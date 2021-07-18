package com.example.hb.java.jacksonLibrary;

import com.example.hb.resource.RoverResource;
import com.example.hb.resource.rover.BorderResource;
import com.example.hb.resource.rover.PositionResource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa
 */
public class Jackson {

    public static ObjectMapper mapper = new ObjectMapper();

    public static String jsonSample = "{ \"borders\": { \"x\": 5, \"y\": 5 }, \"roverList\": [ { \"x\": 1, \"y\": 2, \"orientation\": \"N\", \"instructions\": [ \"L\", \"M\", \"L\", \"M\", \"L\", \"M\", \"L\", \"M\", \"M\" ] }, { \"x\": 3, \"y\": 3, \"orientation\": \"E\", \"instructions\": [ \"M\", \"M\", \"R\", \"M\", \"M\", \"R\", \"M\", \"R\", \"R\", \"M\" ] } ] }";

    public static void main(String[] args) {
        objectMapper_();
    }

    private static void objectMapper_() {
        RoverResource roverResource = new RoverResource();
        roverResource.setBorders(new BorderResource(5, 5));

        File newState = new File("object-mapper-sample.json");
        File secondState = new File("object-mapper-sample-2.json");
        try {
            mapper.writeValue(newState, roverResource);
            mapper.writeValue(secondState, mapper.readValue(jsonSample, JsonNode.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Complete!");

    }

}
