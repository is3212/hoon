package com.test.dto;

public class UserInfo {
	private int userNum;
	private String userId;
	private String userName;
	private int age;
	private String address;
	private String hp1;
	private String hp2;
	private String hp3;
	private String userPwd;
	
	public int getUserNum(){
		return userNum;
	}
	
	public void setUserNum(int userNum){
		this.userNum=userNum;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public int getUserAge(){
		return age;
	}
	
	public void setUserAge(int age){
		this.age=age;
	}
	
	public String getUserAddress(){
		return address;
	}
	
	public void setUserAddress(String address){
		this.address=address;
	}
	
	public String getUserHp1(){
		return hp1;
	}
	
	public void setUserHp1(String hp1){
		this.hp1=hp1;
	}
	
	public String getUserHp2(){
		return hp2;
	}
	
	public void setUserHp2(String hp2){
		this.hp2=hp2;
	}

	
	public String getUserHp3(){
		return hp3;
	}
	
	public void setUserHp3(String hp3){
		this.hp3=hp3;
	}
	
	public String getUserPwd(){
		return userPwd;
	}
	
	public void setUserPwd(String userPwd){
		this.userPwd=userPwd;
	}
}
