package com.example.hb.enums;

/**
 * Order matters!!!
 * next value runs "counter clockwise" on the map.
 */
public enum OrientationEnum {
    N(0),
    W(1),
    S(2),
    E(3);

    private int crud;

    OrientationEnum(int crud) {
        this.crud = crud;
    }

    public OrientationEnum next() {
        if (this == E) {
            return N;
        } else {
            return OrientationEnum.values()[this.crud + 1];
        }
    }

    public OrientationEnum previous() {
        if (this == N) {
            return E;
        } else {
            return OrientationEnum.values()[this.crud - 1];
        }
    }
}
