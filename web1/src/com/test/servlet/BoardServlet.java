package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.BoardInfo;
import com.test.service.BoardService;

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		BoardInfo bi=new BoardInfo();

		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		
		if(command.equals("SIGNIN")){       
		String bititle = req.getParameter("bititle");
		String bicontent = req.getParameter("bicontent");
		String bipwd = req.getParameter("bipwd");
		String creusr = req.getParameter("creusr");
		String credat = req.getParameter("credat");
	
		System.out.println(bititle + "," + bicontent + "," + bipwd + "," + creusr + ", " + credat);
		bi.setBoardTitle(bititle);
		bi.setBoardContent(bicontent);
		bi.setBoardPwd(bipwd);
		bi.setBoardUser(creusr);
		bi.setBoardDate(credat);
	
		if(bs.InsertBoard(bi)){
			doProcess(resq,"저장 잘 됐습니다."); 
		}else{
			doProcess(resq,"저장 안 됨, 값 똑바로 입력하시오");
		}
	}else if(command.equals("DELETE")){         
		String boardnum = req.getParameter("binum");
		bi.setBoardNum(Integer.parseInt(boardnum));
		System.out.println("삭제할 번호 : " + boardnum);
		boolean isdelete=bs.deleteBoard(bi);
		if(isdelete==true){
			doProcess(resq,"삭제 완료");	
		}else{
			doProcess(resq,"삭제 실패");
		}
	}else if(command.equals("SELECT")){  
		String boardTitle = req.getParameter("bititle");
		System.out.println("이름 : " + boardTitle);
		if (boardTitle != null && !boardTitle.equals("")) {
			bi.setBoardTitle("%" + boardTitle + "%");
		}
		List<BoardInfo> boardList  = bs.selectBoard(bi);
		String result="번호{/}제목{/}내용{/}작성자{+}";
		result+="dis{/}en{/}en{/}en{+}";
		for(BoardInfo m : boardList){
			result += m.getBoardNum() + "{/}" + m.getBoardTitle() + "{/}" + m.getBoardContent() + "{/}" + m.getBoardUser() + "{+}"; 
		}
		result = result.substring(0, result.length()-3);
		doProcess(resq, result);
	}
	}
	
	
	
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}
