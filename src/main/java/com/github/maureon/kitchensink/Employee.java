package com.github.maureon.kitchensink;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Employee {
	
	@Id
	@EqualsAndHashCode.Include
	@ToString.Include
	private String id;
	
	@ToString.Include	
	private String firstname;
	
	@ToString.Include	
	private String middlename;

	@ToString.Include	
	private String lastname;

	@ToString.Include	
	private LocalDate birthdate;
	
	@ToString.Include	
	private Boolean active;

	
}
