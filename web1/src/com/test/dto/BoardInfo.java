package com.test.dto;

public class BoardInfo {
	private int biNum;
	private String biTitle;
	private String biContent;
	private String biPwd;
	private String creUsr;
	private String creDat;

	
	public int getBoardNum(){
		return biNum;
	}
	
	public void setBoardNum(int biNum){
		this.biNum=biNum;
	}
	
	public String getBoardTitle(){
		return biTitle;
	}
	
	public void setBoardTitle(String biTitle){
		this.biTitle=biTitle;
	}
	
	public String getBoardContent(){
		return biContent;
	}
	
	public void setBoardContent(String biContent){
		this.biContent=biContent;
	}
	
	public String getBoardPwd(){
		return biPwd;
	}
	
	public void setBoardPwd(String biPwd){
		this.biPwd=biPwd;
	}
	
	public String getBoardUser(){
		return creUsr;
	}
	
	public void setBoardUser(String creUsr){
		this.creUsr=creUsr;
	}
	
	public String getBoardDate(){
		return creDat;
	}
	
	public void setBoardDate(String creDat){
		this.creDat=creDat;
	}
	
}

