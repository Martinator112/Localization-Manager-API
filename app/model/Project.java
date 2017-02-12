package model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Project extends BaseModelClass {

	private String Name;

	private String ProjectKey;

	private boolean SyncVersions;

	private String Git;

	private String ResourcePath;

	private User Assignee;

	private Converter Converter;

	private List<String> Branches;

	private Integer WordCount;

	private String Status;

	private String HashMapIdentifier;

	public String getHashMapIdentifier() {
		return HashMapIdentifier;
	}

	public void setHashMapIdentifier(String hashMapIdentifier) {
		HashMapIdentifier = hashMapIdentifier;
	}

	public Integer getWordCount() {
		return WordCount;
	}

	public void setWordCount(Integer wordCount) {
		WordCount = wordCount;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public boolean getSyncVersions() {
		return SyncVersions;
	}

	public List<String> getBranches() {
		return Branches;
	}

	public void setBranches(List<String> branches) {
		Branches = branches;
	}

	public String getProjectKey() {
		return ProjectKey;
	}

	public void setProjectKey(String projectKey) {
		ProjectKey = projectKey;
	}

	public void setSyncVersions(boolean syncVersions) {
		this.SyncVersions = syncVersions;
	}

	public String getGit() {
		return Git;
	}

	public void setGit(String git) {
		Git = git;
	}

	public String getResourcePath() {
		return ResourcePath;
	}

	public void setResourcePath(String resourcePath) {
		ResourcePath = resourcePath;
	}

	public void setAssignee(User assignee) {
		Assignee = assignee;
	}

	public User getAssignee() {

		return Assignee;
	}

	public void setConverter(model.Converter converter) {
		Converter = converter;
	}

	public model.Converter getConverter() {
		return Converter;
	}


	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}


	public Project()
	{

	}

	public static Project create(JsonNode newProjectJson) {
		ObjectMapper objMapper = new ObjectMapper();
		Project newProject = null;
		try {
			newProject = objMapper.treeToValue(newProjectJson, Project.class);
		}
		catch (JsonProcessingException e) {
			System.err.println("Error parsing project json into Project model: " + e.getMessage());
		}
		return newProject;
	}
}
