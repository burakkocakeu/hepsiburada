package com.example.hb.repository;

import com.example.hb.resource.RedisRoverResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeploymentRepository extends CrudRepository<RedisRoverResource, String> {
}
