package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.test.service.UserService;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		//html화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		UserService us = new UserService();
		
		
		//UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		//UserService로 us 레퍼런스 변수를 생성
		if(command.equals("SIGNIN")){        //인서트
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String class_num = req.getParameter("class_num");
		String age = req.getParameter("age");
		
		//위에서 받은 String  변수를 출력해줌(톰캣 콘솔창에)
		System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age);
		
		//해쉬맵 생성
				HashMap hm=new HashMap();
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("id", id);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("pwd", pwd);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("name", name);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("class_num", class_num);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
				hm.put("age", age);
				//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
		//위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
				//위에서 생성하고 값을 저장한 HashMap인 hm레퍼런스 변수를 같이 던짐
		if(us.InsertUser(hm)){
			doProcess(resq,"저장 잘 됐구만!!!!"); //웹에다 글 을 띄운다
		}else{
			doProcess(resq,"값 똑바로 입력안하냐응!!!!");//웹에다 글 을 띄운다
		}
	}else if(command.equals("DELETE")){         //딜리트
		String user_num = req.getParameter("user_num");
		HashMap hm=new HashMap();
		hm.put("num", user_num);
		System.out.println("삭제할 번호 : " + user_num);
		us.deleteUser(hm);
		
	}else if(command.equals("UPDATE")){ //업데이트
		String name=req.getParameter("name");
		String class_num=req.getParameter("class_num");
		String age=req.getParameter("age");
		String user_num=req.getParameter("user_num");
		HashMap hm =new HashMap();
		hm.put("name", name);
		hm.put("class_num", class_num);
		hm.put("age", age);
		hm.put("num",user_num);
		System.out.println("업데이트 할 번호 : " + user_num);
		us.updateUser(hm);
	}else if(command.equals("SELECT")){  //셀렉트
		String name=req.getParameter("name");
		HashMap hm =new HashMap();
		if(name!=null && !name.equals("")){
			hm.put("name", "%" + name + "%");
		}
		List<HashMap> userList = us.selectUser(hm);
		for(int i=0;i<userList.size();i++){
		doProcess2(resq,userList.get(i));
	}
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