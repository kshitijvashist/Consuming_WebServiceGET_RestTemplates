package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class SportList {
	private List<Sports> sportsList;

	public List<Sports> getSportsList() {
		return sportsList;
	}

	public void setSportsList(List<Sports> sportsList) {
		this.sportsList = sportsList;
	}

	public SportList() {
		sportsList=new ArrayList<Sports>();
		// TODO Auto-generated constructor stub
	}
	

}
