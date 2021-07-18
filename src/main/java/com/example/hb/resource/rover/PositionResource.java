package com.example.hb.resource.rover;

import com.example.hb.enums.DirectionEnum;
import com.example.hb.enums.OrientationEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PositionResource implements Serializable {

    @NotNull
    private Integer x;

    @NotNull
    private Integer y;

    @NotNull
    private OrientationEnum orientation;

    @NotBlank
    private List<DirectionEnum> instructions;

    public PositionResource(Integer x, Integer y, OrientationEnum orientation, List<DirectionEnum> instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public void adjustOrientation(BorderResource borders, DirectionEnum direction) {
        switch (direction) {
            case L -> orientation = orientation.next();
            case R -> orientation = orientation.previous();
            case M -> {
                if (orientation == OrientationEnum.N) {
                    moveToNorth(borders);
                } else
                if (orientation == OrientationEnum.W) {
                    moveToWest();
                } else
                if (orientation == OrientationEnum.S) {
                    moveToSouth();
                } else
                if (orientation == OrientationEnum.E) {
                    moveToEast(borders);
                }
            }
            default -> {}
        }
    }

    public void moveToNorth(BorderResource borders) {
        if (borders.getY() > y) {
            y++;
        } else {
            System.out.println("Warn: Movement to 'North' is aborted by the limitation of defined borders on Y axis! " + borders.getY());
        }
    }

    public void moveToWest() {
        if (x > 0) {
            x--;
        } else {
            System.out.println("Warn: Movement to 'West' is aborted by the limitation of defined borders on X axis! 0");
        }
    }

    public void moveToSouth() {
        if (y > 0) {
            y--;
        } else {
            System.out.println("Warn: Movement to 'South' is aborted by the limitation of defined borders on Y axis! 0");
        }
    }

    public void moveToEast(BorderResource borders) {
        if (borders.getX() > x) {
            x++;
        } else {
            System.out.println("Warn: Movement to 'East' is aborted by the limitation of defined borders on X axis! " + borders.getX());
        }
    }

    @Override
    public String toString() {
        return "PositionResource{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                ", instructions=" + instructions +
                '}';
    }

}
