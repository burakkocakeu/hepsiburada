package com.example.hb.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("deployments")
@Getter @Setter
public class RedisRoverResource implements Serializable {

    String id;

    RoverResource resource;

}
