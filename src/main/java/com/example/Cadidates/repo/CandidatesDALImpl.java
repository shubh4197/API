package com.example.Cadidates.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.Candidates.model.Candidates;

@Repository
public class CandidatesDALImpl implements CandidatesDAL{
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Candidates> findAll(){
		return mongo.findAll(Candidates.class);
	}
	
	@Override
	public Candidates find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongo.find(q, Candidates.class).get(0);
	}
	
	@Override
	public List<Candidates> findbyName(String name){
		Query q=new Query();
		q.addCriteria(Criteria.where("name").is(name));
		return mongo.find(q, Candidates.class);
	}
	
	@Override
	public Candidates save(Candidates emp) {
		return mongo.save(emp);
	}
	
	@Override
	public void remove(Candidates emp) {
		mongo.remove(emp);
	}

}
