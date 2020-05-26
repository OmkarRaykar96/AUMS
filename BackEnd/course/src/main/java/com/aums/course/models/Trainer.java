package com.aums.course.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trainer extends Employee {

	private int trainerId;
	private String activeFlag;

}
