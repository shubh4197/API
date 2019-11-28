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
public class Posts {

	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	String id;
	
	String projectname;
	
	String description;
	
	String price;
	
	String credits;
	
	List<String> skills;
	
	@DBRef
	@JsonIgnoreProperties({"appliedPosts","selectedPosts"})
	List<Candidates> selectedCandidates= new ArrayList<Candidates>();
	
	
	@DBRef
	@JsonIgnoreProperties({"appliedPosts","selectedPosts"})
	List<Candidates> appliedCandidates= new ArrayList<Candidates>();

	public Posts() {
		super();
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public List<Candidates> getSelectedCandidates() {
		return selectedCandidates;
	}

	public void setSelectedCandidates(List<Candidates> selectedCandidates) {
		this.selectedCandidates = selectedCandidates;
	}

	public List<Candidates> getAppliedCandidates() {
		return appliedCandidates;
	}

	public void setAppliedCandidates(List<Candidates> appliedCandidates) {
		this.appliedCandidates = appliedCandidates;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	
	
	
}
