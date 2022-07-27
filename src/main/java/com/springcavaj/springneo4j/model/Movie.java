package com.springcavaj.springneo4j.model;

import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Movie {
	
	@Id
	@GeneratedValue
    private Long id;
    private String title;
    private Long released;
    private String tagline;
    
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<Role> roles;
    
    public Movie() {
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getReleased() {
		return released;
	}
	public void setReleased(Long released) {
		this.released = released;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", released=");
		builder.append(released);
		builder.append(", tagline=");
		builder.append(tagline);
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}
}
