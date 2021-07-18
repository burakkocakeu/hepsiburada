package com.example.hb.controller;

import com.example.hb.enums.DirectionEnum;
import com.example.hb.enums.OrientationEnum;
import com.example.hb.resource.RoverResource;
import com.example.hb.resource.rover.BorderResource;
import com.example.hb.resource.rover.PositionResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
/*@AutoConfigureMockMvc(secure = false)*/
class RoverControllerTest {
/*
    @Autowired
    private MockMvc mvc;

    @Test
    public void deployTest() throws Exception {

        BorderResource borderResource = new BorderResource();
        borderResource.setX(5);
        borderResource.setY(5);

        List<PositionResource> list = new ArrayList<>();
        list.add(mockFirst());
        list.add(mockSecond());

        RoverResource resource = new RoverResource();
        resource.setBorders(borderResource);
        resource.setRoverList(list);

        mvc.perform(post("/deploy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(resource)))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"x\":1,\"y\":3,\"orientation\":\"N\"},{\"x\":5,\"y\":1,\"orientation\":\"E\"}]"));

    }

    private PositionResource mockFirst() {
        PositionResource positionResource = new PositionResource();
        positionResource.setX(1);
        positionResource.setY(2);
        positionResource.setOrientation(OrientationEnum.N);
        List<DirectionEnum> directionList = new ArrayList<>();
        directionList.add(DirectionEnum.L);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.L);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.L);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.L);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.M);
        positionResource.setInstructions(directionList);

        return positionResource;
    }

    private PositionResource mockSecond() {
        PositionResource positionResource = new PositionResource();
        positionResource.setX(3);
        positionResource.setY(3);
        positionResource.setOrientation(OrientationEnum.E);
        List<DirectionEnum> directionList = new ArrayList<>();
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.R);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.R);
        directionList.add(DirectionEnum.M);
        directionList.add(DirectionEnum.R);
        directionList.add(DirectionEnum.R);
        directionList.add(DirectionEnum.M);
        positionResource.setInstructions(directionList);

        return positionResource;
    }*/
}