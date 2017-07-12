package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.CommentService;




public class CommentServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		CommentService cs = new CommentService();
		//String name1=req.getParameter("name");
	//	String pwd1=req.getParameter("pass");
		//String a=req.getParameter("a");
		//System.out.println("Input html에서 너님이 던진값 =>" + name1 + pwd1 + a);
		
		
		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		
		
		if(command.equals("insert")){
		String content=req.getParameter("content");
		String UI_num=req.getParameter("UI_num");
		String B_num=req.getParameter("B_num");
		
		System.out.println(content + "," + UI_num + "," + B_num );
		
		HashMap hm= new HashMap();
		hm.put("content", content);
		hm.put("UI_num", UI_num);
		hm.put("B_num", B_num);
		
		if(cs.InsertComment(hm)){
			doProcess(resq,"저장 잘 됨!!");
		}else{
			doProcess(resq,"값 똑바로 입력해");		
			}
		}else if(command.equals("delete")){
			String num=req.getParameter("num");
			HashMap hm=new HashMap();
			hm.put("num", num);
			System.out.println("삭제할 번호 : " + num);
			cs.deleteComment(hm);
		}else if(command.equals("update")){
			String content=req.getParameter("content");
			String UI_num=req.getParameter("UI_num");
			String B_num=req.getParameter("B_num");
			String num=req.getParameter("num");
			HashMap hm=new HashMap();
			hm.put("content",content);
			hm.put("UI_num",UI_num);
			hm.put("B_num",B_num);
			hm.put("num",num);
			System.out.println("업데이트 할 번호 : " + num);
			cs.updateComment(hm);
		}else if(command.equals("select")){
			String num=req.getParameter("num");
			HashMap hm=new HashMap();
			if(num!=null && !num.equals("")){
				hm.put("user_num", "%" + num + "%");
			}
			List<HashMap> boardList=cs.selectComment(hm);
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