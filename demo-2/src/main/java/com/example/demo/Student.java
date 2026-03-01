package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private int uid;
	private String name;
	private String stream;
	private String gender;
	public int getUid() {
		return uid;
	}
	public String getName() {
		return name;
	}
	public String getStream() {
		return stream;
	}
	public String getGender() {
		return gender;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
