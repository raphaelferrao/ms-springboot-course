package com.example.hrpayroll.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Worker implements Serializable {
	
	private static final long serialVersionUID = -5577132131042730578L;

	private Long id;
	private String name;
	private Double dailyIncome;

}
