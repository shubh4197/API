package com.example.Cadidates.repo;

import java.util.List;

import com.example.Candidates.model.Candidates;

public interface CandidatesDAL {

	List<Candidates> findAll();

	Candidates find(String id);

	List<Candidates> findbyName(String name);

	Candidates save(Candidates emp);

	void remove(Candidates emp);

}
