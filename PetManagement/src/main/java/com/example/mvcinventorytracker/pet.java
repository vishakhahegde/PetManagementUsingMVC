package com.example.mvcinventorytracker;

import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;


@Document("pets")
public class pet {
	private String name;
	private String Animal;
	private String Owner;
	private Number age;
	@Id
    private String id;

    // ... other fields and methods ...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	//Getter Functions
	public String getName() {
		return name;
	}
	public String getAnimal() {
		return Animal;
	}
	public String getOwner() {
		return Owner;
	}
	public Number getAge() {
		return age;
	}

	//Setter Functions
	public void setName(String name) {
		this.name = name;
	}
	public void setAnimal(String Animal) {
		this.Animal = Animal;
	}
	public void setOwner(String Owner) {
		this.Owner = Owner;
	}
	public void setAge(Number age) {
		this.age = age;
	}

}
