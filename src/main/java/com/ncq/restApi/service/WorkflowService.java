package com.ncq.restApi.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ncq.restApi.model.Workflow;

@Transactional
public interface WorkflowService  extends CrudRepository<Workflow, Long> {

	public Iterable<Workflow> findByNameAndEnabled(String name, Boolean status);

	public Iterable<Workflow> findByEnabled(Boolean status);

	public Iterable<Workflow> findByName(String name);

}
