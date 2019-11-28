package com.example.Cadidates.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.Candidates.model.Posts;


@Repository
public class PostsDALImpl implements PostsDAL {

	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Posts> findAll(){
		return mongo.findAll(Posts.class);
	}
	
	@Override
	public Posts find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongo.find(q, Posts.class).get(0);
	}
	
	
	
	@Override
	public Posts save(Posts emp) {
		return mongo.save(emp);
	}
	
	@Override
	public void remove(Posts emp) {
		mongo.remove(emp);
	}
}
