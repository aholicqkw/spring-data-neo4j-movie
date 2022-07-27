package com.springcavaj.springneo4j.model;

public class MovieRequest {
	
	private String personName;
	private String movieName;
	private Long releasedYear;
	private String roleName;
	private String tagLine;
	
	public MovieRequest() {
	}
	
	public MovieRequest(String personName, String movieName, Long releasedYear, String roleName, String tagLine) {
		this();
		this.personName = personName;
		this.movieName = movieName;
		this.releasedYear = releasedYear;
		this.roleName = roleName;
		this.tagLine = tagLine;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Long getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(Long releasedYear) {
		this.releasedYear = releasedYear;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieRequest [personName=");
		builder.append(personName);
		builder.append(", movieName=");
		builder.append(movieName);
		builder.append(", releasedYear=");
		builder.append(releasedYear);
		builder.append(", roleName=");
		builder.append(roleName);
		builder.append(", tagLine=");
		builder.append(tagLine);
		builder.append("]");
		return builder.toString();
	}
}
