package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;


/**
 * The persistent class for the Subjects database table.
 * 
 */
@Entity
@Table(name="Subjects")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int subjectId;

	
	private String eg_Database_Design;

	
	private String subjectName;

	//bi-directional many-to-one association to Cours
	
	private Set<Cours> courses;

	public Subject() {
	}
	
	public Subject(String eg_Database_Design,String subjectName) {
		this.eg_Database_Design=eg_Database_Design;
		this.subjectName=subjectName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id")
	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	@Column(name="`eg Database Design`")
	public String getEg_Database_Design() {
		return this.eg_Database_Design;
	}

	public void setEg_Database_Design(String eg_Database_Design) {
		this.eg_Database_Design = eg_Database_Design;
	}
	@Column(name="subject_name")
	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@OneToMany(mappedBy="subject", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	public Set<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}

	public Cours addCours(Cours cours) {
		getCourses().add(cours);
		cours.setSubject(this);

		return cours;
	}

	public Cours removeCours(Cours cours) {
		getCourses().remove(cours);
		cours.setSubject(null);

		return cours;
	}

}