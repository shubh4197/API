package com.example.Cadidates.repo;

import java.util.List;

import com.example.Candidates.model.Posts;

public interface PostsDAL {

	List<Posts> findAll();

	Posts find(String id);

	Posts save(Posts emp);

	void remove(Posts emp);

}
