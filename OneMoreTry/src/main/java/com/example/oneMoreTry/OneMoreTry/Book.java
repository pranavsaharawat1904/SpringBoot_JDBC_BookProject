package com.example.oneMoreTry.OneMoreTry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class Book {

	private int id;
	private String name;
	private String author;
	private int cost;

	
	
}
