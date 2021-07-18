package com.example.hb.component;

import com.example.hb.java.jacksonLibrary.Jackson;
import com.example.hb.repository.DeploymentRepository;
import com.example.hb.resource.RedisRoverResource;
import com.example.hb.resource.RoverResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RedisComponent {

/*  @Autowired
    private RedisTemplate<String, String> redisTemplate;    */

    final DeploymentRepository repository;

    public RedisComponent(DeploymentRepository repository) {
        this.repository = repository;
    }

    public void save(RoverResource roverResource) /*throws JsonProcessingException*/ {
       /* redisTemplate.opsForValue().set(
                mapper.writeValueAsString(roverResource.getBorders().getX()),
                mapper.writeValueAsString(roverResource));*/
        RedisRoverResource resource = new RedisRoverResource();
        resource.setId(roverResource.getBorders().getX().toString());
        resource.setResource(roverResource);
        repository.save(resource);
    }

    public String findById(String id) throws JsonProcessingException {
        return Jackson.mapper.writeValueAsString(repository.findById(id).get());
        /*return redisTemplate.opsForValue().get(mapper.writeValueAsString(id));*/
    }
}
