package com.example.hb.service;

import com.example.hb.resource.RoverResource;
import com.example.hb.resource.rover.BorderResource;
import com.example.hb.resource.rover.PositionResource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RoverService {

    public List<PositionResource> moveAll(RoverResource roverResource) {

        List<PositionResource> results = new ArrayList<>();

        BorderResource borders = roverResource.getBorders();

        roverResource.getRoverList().stream().forEach(roverPositionResource ->
                results.add(moveRoverToFinalPosition(roverPositionResource, borders)));

        return results;

    }

    private PositionResource moveRoverToFinalPosition(PositionResource roverPositionResource, BorderResource borders) {

        roverPositionResource.getInstructions().stream().forEach(instruction ->
                roverPositionResource.adjustOrientation(borders, instruction));

        PositionResource finalPositionResource = new PositionResource();
        finalPositionResource.setX(roverPositionResource.getX());
        finalPositionResource.setY(roverPositionResource.getY());
        finalPositionResource.setOrientation(roverPositionResource.getOrientation());

        return finalPositionResource;

    }
}
