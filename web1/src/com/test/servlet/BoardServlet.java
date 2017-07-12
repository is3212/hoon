package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.test.service.BoardService;
import com.test.service.UserService;

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		//String name1=req.getParameter("name");
	//	String pwd1=req.getParameter("pass");
		//String a=req.getParameter("a");
		//System.out.println("Input html에서 너님이 던진값 =>" + name1 + pwd1 + a);
		
		
		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		
		
		if(command.equals("insert")){
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String writer=req.getParameter("user_num");
		
		System.out.println(title + "," + content + "," + writer);
		
		HashMap hm= new HashMap();
		hm.put("title", title);
		hm.put("content", content);
		hm.put("user_num", writer);
		
		if(bs.InsertBoard(hm)){
			doProcess(resq,"저장 잘 됨!!");
		}else{
			doProcess(resq,"값 똑바로 입력해");		
			}
		}else if(command.equals("delete")){
			String num=req.getParameter("num");
			HashMap hm=new HashMap();
			hm.put("num", num);
			System.out.println("삭제할 번호 : " + num);
			bs.deleteBoard(hm);
		}else if(command.equals("update")){
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String writer=req.getParameter("user_num");
			String num=req.getParameter("num");
			HashMap hm=new HashMap();
			hm.put("title",title);
			hm.put("content",content);
			hm.put("user_num",writer);
			hm.put("num",num);
			System.out.println("업데이트 할 번호 : " + num);
			bs.updateBoard(hm);
		}else if(command.equals("select")){
			String writer=req.getParameter("user_num");
			HashMap hm=new HashMap();
			if(writer!=null && !writer.equals("")){
				hm.put("user_num", "%" + writer + "%");
			}
			List<HashMap> boardList=bs.selectBoard(hm);
			for(int i=0;i<boardList.size();i++){
				doProcess2(resq,boardList.get(i));
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