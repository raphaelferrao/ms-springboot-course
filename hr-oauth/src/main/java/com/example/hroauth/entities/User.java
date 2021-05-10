package com.example.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = -2736516583883870256L;

	@NonNull
	@EqualsAndHashCode.Include
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private Set<Role> roles = new HashSet<>();

}
