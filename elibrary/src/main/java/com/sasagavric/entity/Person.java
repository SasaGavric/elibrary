package com.sasagavric.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sasa Gavric
 *
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class Person {
	
	@Column(name = "first_name")
	@NotNull
	@Size(min = 2, max = 35)
	@Value("${foo.firstName}")
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@Size(min = 2, max = 35)
	private String lastName;

}
