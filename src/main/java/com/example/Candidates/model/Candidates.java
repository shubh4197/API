package com.example.Candidates.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Candidates {
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	String id;

	String name;
	
	String username;
	
	String password;

	List<String> skills;

	String age;

	int dxc;

	int creditsEarned;

	
	@DBRef(lazy = true)
	@JsonIgnoreProperties({"appliedCandidates","selectedCandidates"})
	List<Posts> selectedPosts=new ArrayList<Posts>();
	

	@DBRef(lazy=true)
	@JsonIgnoreProperties({"appliedCandidates","selectedCandidates"})
	List<Posts> appliedPosts=new ArrayList<Posts>();

	public Candidates() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getDXC() {
		return dxc;
	}

	public void setDXC(int dXC) {
		dxc = dXC;
	}

	public List<Posts> getSelectedPosts() {
		return selectedPosts;
	}

	public void setSelectedPosts(List<Posts> selectedPosts) {
		this.selectedPosts = selectedPosts;
	}

	public List<Posts> getAppliedPosts() {
		return appliedPosts;
	}

	public void setAppliedPosts(List<Posts> appliedPosts) {
		this.appliedPosts = appliedPosts;
	}
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", name=" + name + ", skills=" + skills + ", age=" + age + ", DXC=" + dxc
				+ ", creditsEarned=" + creditsEarned + ", selectedPosts=" + selectedPosts + ", appliedPosts="
				+ appliedPosts + "]";
	}
	
	

}
