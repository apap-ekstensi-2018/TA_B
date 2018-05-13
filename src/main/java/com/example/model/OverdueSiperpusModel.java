package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverdueSiperpusModel {
	
	private String jumlah_literatur_overdue;
	private String message;
	private String status;
	private String username;

}
