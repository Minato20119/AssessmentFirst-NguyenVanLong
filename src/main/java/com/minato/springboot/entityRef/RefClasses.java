package com.minato.springboot.entityRef;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.minato.springboot.entity.Reservations;

/**
 * @author Minato
 *
 */
@Entity
@Table(name = "Ref_Classes")
public class RefClasses {

	@Column(name = "Class_Number")
	private int classNumber;

	@Column(name = "Class_Number_Description")
	private String classNumberDescription;

	private Set<Reservations> reservations = new HashSet<>();

	@OneToMany(mappedBy = "refClasses", cascade = CascadeType.ALL)
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}

	public RefClasses() {
	}

	public RefClasses(String classNumberDescription) {
		this.classNumberDescription = classNumberDescription;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getClassNumberDescription() {
		return classNumberDescription;
	}

	public void setClassNumberDescription(String classNumberDescription) {
		this.classNumberDescription = classNumberDescription;
	}

}