package com.example.hrworker.services;

import java.util.List;

import com.example.hrworker.entities.Worker;

public interface WorkerService {

	List<Worker> findAll();

	Worker findById(Long id);

}