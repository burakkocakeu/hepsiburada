package com.example.hb.resource.rover;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BorderResource implements Serializable {

    @NotNull
    @Size(min = 1, max = 10)
    private Integer x;

    @NotNull
    @Size(min = 1, max = 10)
    private Integer y;

    public BorderResource(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "BorderResource{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
