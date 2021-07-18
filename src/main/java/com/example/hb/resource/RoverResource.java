package com.example.hb.resource;

import com.example.hb.resource.rover.BorderResource;
import com.example.hb.resource.rover.PositionResource;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class RoverResource implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @NotNull
    private BorderResource borders;

    @NotEmpty
    private List<PositionResource> roverList;

}
