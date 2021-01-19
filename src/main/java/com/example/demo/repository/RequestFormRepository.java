package com.example.demo.repository;

import com.example.demo.entity.RequestForm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestFormRepository extends MongoRepository<RequestForm, String> {

  public RequestForm findBySystem(String system);

  public List<RequestForm> findByStatus(String status);

}