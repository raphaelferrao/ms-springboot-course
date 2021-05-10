package com.example.hroauth.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	
	private static final long serialVersionUID = -8042767893116474260L;

	private Long id;
	
	@EqualsAndHashCode.Include
	private String roleName;
	
}