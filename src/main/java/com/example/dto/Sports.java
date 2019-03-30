package com.example.dto;

import java.util.List;

public class Sports {
	private int sportsNo;
	private String sportsName;
	private int teamCount;
	private String sportsType;
	public Sports() {
		super();
	}
	public Sports(int sportsNo, String sportsName, int teamCount, String sportsType) {
		super();
		this.sportsNo = sportsNo;
		this.sportsName = sportsName;
		this.teamCount = teamCount;
		this.sportsType = sportsType;
	}
	
	
	public int getSportsNo() {
		return sportsNo;
	}
	@Override
	public String toString() {
		return "Sports [sportsNo=" + sportsNo + ", sportsName=" + sportsName + ", teamCount=" + teamCount
				+ ", sportsType=" + sportsType + "]";
	}
	public void setSportsNo(int sportsNo) {
		this.sportsNo = sportsNo;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public int getTeamCount() {
		return teamCount;
	}
	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}
	public String getSportsType() {
		return sportsType;
	}
	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}
	

}
