package com.example.Cadidates.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cadidates.repo.CandidatesDAL;
import com.example.Cadidates.repo.PostsDAL;
import com.example.Candidates.model.Candidates;
import com.example.Candidates.model.Posts;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PostsController {

	@Autowired
	CandidatesDAL candi;

	@Autowired
	PostsDAL postRepo;

	@PostMapping("/posts")
	public Posts Posts(@RequestBody Posts post1) {
		postRepo.save(post1);
		return post1;
	}

	@PutMapping("/postsApply/{id}/{id1}")
	public Posts Apply(@PathVariable String id1, @PathVariable String id) {
		Candidates candy = candi.find(id1);
		Posts post1 = postRepo.find(id);
		List<Candidates> lol = new ArrayList<>();
		List<Posts> lol2 = new ArrayList<>();
		if (post1.getAppliedCandidates() != null) {
			lol = post1.getAppliedCandidates();
		}
		lol.add(candy);
		post1.setAppliedCandidates(lol);
		if (candy.getAppliedPosts() != null) {
			lol2 = candy.getAppliedPosts();
		}
		lol2.add(post1);
		candy.setAppliedPosts(lol2);
		candi.save(candy);
		postRepo.save(post1);
		return post1;
	}
	
	@GetMapping("posts1/{id}")
	public Posts dap(@PathVariable String id) {
		return postRepo.find(id);
	}

	@PutMapping("/postsAccept/{id}/{id1}")
	public Posts Accept(@PathVariable String id1, @PathVariable String id) {
		Candidates candy = candi.find(id1);
		Posts post1 = postRepo.find(id);
		List<Candidates> lol = new ArrayList<>();
		List<Posts> lol2 = new ArrayList<>();
		if (post1.getSelectedCandidates() != null) {
			lol = post1.getSelectedCandidates();
		}
		lol.add(candy);
		post1.setSelectedCandidates(lol);
		if (candy.getSelectedPosts() != null) {
			lol2 = candy.getSelectedPosts();
		}
		lol2.add(post1);
		candy.setSelectedPosts(lol2);
		int index=0;
		int index1=0;
		List<Candidates> lol3 = post1.getAppliedCandidates();
		for(Candidates i:lol3)
		{
			if(i==candy)
			{
				 index=lol3.indexOf(i);
			}
		}
		lol3.remove(index);
		post1.setAppliedCandidates(lol3);
		List<Posts> lol4 = candy.getAppliedPosts();
		for(Posts i:lol4)
		{
			if(i==post1)
			{
				 index1=lol3.indexOf(i);
			}
		}
		lol4.remove(index1);
		candy.setAppliedPosts(lol4);
		candi.save(candy);
		postRepo.save(post1);
		return post1;
	}

	@PutMapping("/postsDecline/{postId}/{candidateId}")
	public Posts decline(@PathVariable String candidateId, @PathVariable String postId) {
		Candidates candidate = candi.find(candidateId);
		Posts post = postRepo.find(postId);
		int index=0;
		int index1=0;
		List<Candidates> lol3 = post.getAppliedCandidates();
		for(Candidates i:lol3)
		{
			if(i==candidate)
			{
				 index=lol3.indexOf(i);
			}
		}
		lol3.remove(index);
		post.setAppliedCandidates(lol3);
		List<Posts> lol4 = candidate.getAppliedPosts();
		for(Posts i:lol4)
		{
			if(i==post)
			{
				 index1=lol3.indexOf(i);
			}
		}
		lol4.remove(index1);
		candidate.setAppliedPosts(lol4);
	    candi.save(candidate);
		postRepo.save(post);
        return post;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
	public List<Posts> fetch(){
		return postRepo.findAll();
	}
	
}
