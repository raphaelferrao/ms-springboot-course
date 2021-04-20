package com.example.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Override
	public List<Worker> findAll(){
		return workerRepository.findAll();
	}

	@Override
	public Worker findById(Long id) {
		Worker obj = workerRepository.findById(id).get();
		return obj;
	}
	
}
