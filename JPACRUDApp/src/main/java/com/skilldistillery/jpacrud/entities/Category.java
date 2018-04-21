package com.skilldistillery.jpacrud.entities;

public enum Category {
	FAST_CASUAL("Fast Casual"), AMERICAN_CASUAL("American Casual"), ASIAN("Asian"), MEXICAN("Mexican"), BREAKFAST("Breakfast"); 
	
	private String display;
	
	private Category(String display){
		this.display = display;
	}
	public String toString() {
		return display;
	}
	
}
