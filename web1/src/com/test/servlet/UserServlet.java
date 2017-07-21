package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.test.dto.UserInfo;
import com.test.service.UserService;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private static final UserInfo UserInfo = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		//html화면에서 던진 값을 각각 String 변수로 받기 시작
		UserService us = new UserService();
		//String name1=req.getParameter("name");
		//String pwd1=req.getParameter("pass");
		//System.out.println("Input html에서 너님이 던진값 =>" + name1 + pwd1);
		
		//String op1=req.getParameter("op");
		//System.out.println("연산자=>" + op1);
		
		//String id1=req.getParameter("id");
		//String pwd2=req.getParameter("pwd");
		
		//System.out.println("id=>" + id1 + " 비밀번호 =>" + pwd2 );
		
		
		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		
		//UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		//UserService로 us 레퍼런스 변수를 생성
		if(command.equals("SIGNIN")){        //인서트
		String useid = req.getParameter("useid");
		String username = req.getParameter("username");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String hp1 = req.getParameter("hp1");
		String hp2= req.getParameter("hp2");
		String hp3= req.getParameter("hp3");
		String userpwd = req.getParameter("userpwd");
		//위에서 받은 String  변수를 출력해줌(톰캣 콘솔창에)
		System.out.println(useid + "," + userpwd + "," + username + "," + address + ", " + hp1 + "," + hp2 + "," + hp3 + "," + age);
		UserInfo ui=new UserInfo();
		ui.setUserId(useid);
		ui.setUserPwd(userpwd);
		ui.setUserName(username);
		ui.setUserAddress(address);
		ui.setUserHp1(hp1);
		ui.setUserHp2(hp2);
		ui.setUserHp3(hp3);
		ui.setUserAge(Integer.parseInt(age));
		/*
		//해쉬맵 생성
				HashMap hm=new HashMap();
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("useid", useid);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("username", username);
				hm.put("age", age);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("address", address);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("hp1", hp1);
				hm.put("hp2", hp2);
				hm.put("hp3", hp3);
				hm.put("userpwd", userpwd);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
		//위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
				//위에서 생성하고 값을 저장한 HashMap인 hm레퍼런스 변수를 같이 던짐
				 */
		if(us.InsertUser(ui)){
			doProcess(resq,"저장 잘 됐구만!!!!"); //웹에다 글 을 띄운다
		}else{
			doProcess(resq,"값 똑바로 입력안하냐응!!!!");//웹에다 글 을 띄운다
		}
	}else if(command.equals("DELETE")){         //딜리트
		String usernum = req.getParameter("usernum");
		UserInfo ui=new UserInfo();
		ui.setUserNum(Integer.parseInt(usernum));
		System.out.println("삭제할 번호 : " + usernum);
		boolean isdelete=us.deleteUser(ui);
		if(isdelete==true){
			doProcess(resq,"삭제 완료");	
		}else{
			doProcess(resq,"삭제 실패");
		}
			
		
	}else if(command.equals("UPDATE")){ //업데이트
		String userName=req.getParameter("username");
		String userId=req.getParameter("useid");
		String age=req.getParameter("age");
		String usernum = req.getParameter("usernum");
		UserInfo ui=new UserInfo();
		ui.setUserName((userName));
		ui.setUserId(userId);
		ui.setUserAge(Integer.parseInt(age));
		ui.setUserNum(Integer.parseInt(usernum));
		boolean isUpdate=us.updateUser(ui);
		String result="";
		if(isUpdate==true){
			result="수정 됐다";
			doProcess(resq, result);
		}else{
			result="수정 안됐다";
			doProcess(resq, result);
		}
	}else if(command.equals("SELECT")){  //셀렉트
		String userName = req.getParameter("username");
		UserInfo ui=new UserInfo();
		System.out.println("이름 : " + userName);
		if (userName != null && !userName.equals("")) {
			ui.setUserName("%" + userName + "%");
		}
		List<UserInfo> userList  = us.selectUser(ui);
		String result="번호{/}이름{/}아이디{/}나이{+}";
		result+="dis{/}en{/}en{/}en{+}";
		for(UserInfo m : userList){
			result += m.getUserNum() + "{/}" + m.getUserName() + "{/}" + m.getUserId() + "{/}" + m.getUserAge() + "{+}"; 
		}
		result = result.substring(0, result.length()-3);
		doProcess(resq, result);
		
	}else if(command.equals("LOGIN")){
		String useid=req.getParameter("useid");
		String userpwd=req.getParameter("userpwd");
		UserInfo ui=new UserInfo();
		if(useid!=null && !useid.equals("")){
			ui.setUserId(useid);
		}if(userpwd!=null && !userpwd.equals("")){
			ui.setUserPwd(userpwd);
		}
		doProcess(resq,us.loginUser(ui));
	}
	}
	
	
	
	
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
	public void doProcess2(HttpServletResponse resq, HashMap  writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print( writeStr);
	}
}