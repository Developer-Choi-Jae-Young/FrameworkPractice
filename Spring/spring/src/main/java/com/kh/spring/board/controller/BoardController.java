package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.PageInfo;
import com.kh.spring.common.templage.Pagination;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	/*
	 * 		/board/list 요청이 들어오는 경우
	 * 		=> 메뉴바에서 자유게시판 메뉴 클릭 /board/list 요청 (기본적으로 첫페이지 표시)
	 * 		=> 페이징바 클릭 /board/list?cpage=요청할페이지번호
	 * 
	 */
	@RequestMapping("/list")
	public String boardList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {		
		System.out.println("현재페이지 : " + currentPage);
		
		int listCount = boardService.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 5, 5);
		
		// 게시글 목록 조회
		ArrayList<Board> boardList = boardService.selectList(pi);
		
		model.addAttribute("list", boardList);	// 게시글 목록 데이터
		model.addAttribute("pi", pi);	
		// 페이징 관련 데이터
		return "board/boardList";
	}
	
	@RequestMapping("/enrollForm")
	public String boardEnrollForm(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {		
		
		return "board/boardEnrollForm";
	}
	
	@RequestMapping("/insert")
	public String boardInsert(Board board, MultipartFile upfile, HttpSession session, Model model) {		
		
		System.out.println(board);
		System.out.println(upfile);
		
		// 첨부파일이 있는 경우 -> 전달된 파일을 서버에 저장 + Board 객체에 파일 정보를 저장
		if(!upfile.getOriginalFilename().isEmpty()) { //upfile.getOriginalFileName().equals("")
			board.setOriginName(upfile.getOriginalFilename());
			board.setChangeName("resources/uploadFiles/" + saveFile(upfile, session));
		}
		
		// DB에 게시글 정보 저장 (첨부파일 유/무 상관없이 처리)
		int result = boardService.insertBoard(board);
		
		if(result > 0) {	// 게시글 등록 성공
			session.setAttribute("alertMsg", "게시글 등록 성공");
			return "redirect:/board/list";
		} else {			// 게시글 등록 실패
			model.addAttribute("errorMsg", "게시글 등록 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("/detail")
	public String boardDetail(int bno, Model model) {
		// * 해당 게시글의 조회수를 업데이트
		int result = boardService.increaseCount(bno);
		// * 조회수 증가 성공 시 해당 게시글 정보를 조회
		if( result > 0 ) {
			// * 조회수 증가 성공 시
			//			1) 해당 게시글 정보를 조회
			Board board =  boardService.selectBoard(bno);
			//			2) 조회된 정보를 request 영역에 저장
			model.addAttribute("board", board);
			//			3) 상세페이지로 응답
			return "board/boardDetail";
		} else {
			// * 조회수 증가 실패 시
			//			1) 에러메시지를 request 영역에 저장
			model.addAttribute("errorMsg", "게시물 조회에 실패하였습니다.");
			//			2) 에러페이지 응답
			return "common/errorPage";
		}		
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(int bno, Model model) {
		// 게시글 번호(bno)에 해당하는 데이터 조회
		Board board = boardService.selectBoard(bno);
		
		if(board != null) {
			model.addAttribute("board", board);
			return "board/boardUpdate";
		} else {
			model.addAttribute("errorMsg", "게시글을 수정할 수 없습니다.");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("/update")
	public String boardUpdate(Board board, MultipartFile upfile, HttpSession session, Model model) {
		System.out.println(board);
		System.out.println(upfile);
		/*
		 *  새로 추가된 첨부파일이 있을 경우
		 *  	=> 기존에 첨부파일이 있다면, 이전 파일은 제거(삭제)
		 *  	   새로 추가된 첨부파일은 서버에 저장
		 *  	   첨부파일의 원본명, 저장경로(변경된파일명)를 DB에 저장
		 */
		if(!upfile.getOriginalFilename().isEmpty() ) {
			// 기존에 첨부파일이 있다면 기존 파일 제거
			if(board.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(board.getChangeName()));
			}
			
			// 새로 추가된 첨부파일 서버에 저장
			String changeName = saveFile(upfile, session);
			
			// DB에 저장하기 위해 Board객체에 새로 추가된 파일 정보 저장
			board.setOriginName(upfile.getOriginalFilename());
			board.setChangeName("resources/uploadFiles/" + changeName);
		}
		
		// Board 객체에는 제목(boardTitle), 내용(boardContent) 필수적으로 값이 있을 것임
		/*
		 * 1) 기존 첨부파일 x, 새로운 첨부파일 x
		 * 	  => originName : null, changeName : null
		 * 
		 * 2) 기존 첨부파일 o, 새로운 첨부파일 x
		 * 	  => originName : 기존 첨부파일의 원본명, changeName : 기존 첨부파일의 변경된 파일명
		 * 
		 * 3) 기존 첨부파일 o, 새로운 첨부파일 o
		 * 	  => originName : 새로 추가된 첨부파일의 원본명, changeName : 새로 추가된 첨부파일의 변경된 파일정보
		 * 
		 * 4) 기존 첨부파일 x, 새로운 첨부파일 o
		 * 	  => originName : 새로 추가된 첨부파일의 원본명, changeName : 새로 추가된 첨부파일의 변경된 파일정보 
		 */
		
		int result = boardService.updateBoard(board);
		
		if(result > 0) {
			// 수정 성공 시 해당 게시글의 상세페이지로 응답
			return "redirect:/board/detail?bno=" + board.getBoardNo();
		} else {
			// 수정 실패 시 오류메시지와 함께 오류페이지로 응답
			model.addAttribute("errorMsg", "게시글 수정 실패!");
			return "common/errorPage";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/rlist", produces="application/json;charset=UTF-8")
	public String selectReplyList(int bno) {
		// 어떤 게시글의 댓글 목록 조회 => ArrayList<Reply>
		ArrayList<Reply> list = boardService.selectReplyList(bno);
		
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping("/rinsert")
	public String insertReplyList(Reply r) {
		int result = boardService.insertReply(r);
		
		if(result > 0) {
			return "success";
		} else {
			return "fail";	
		}
	}
	
	@RequestMapping("/delete")
	public String boardDelete(int bno, Model model, HttpSession session) {
		System.out.println(bno);
		int result = boardService.deleteBoard(bno);
		
		if(result > 0) {
			// 게시글 삭제 성공 => 게시글 목록 페이지 응답
			session.setAttribute("alertMsg", "게시글 삭제 성공했습니다.");
			return "redirect:/board/list";
		} else {
			// 게시글 삭제 실패 => 오류 페이지 응답
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/top5", produces="application/json;charset=UTF-8")
	public String selectBoardTop5() {
		ArrayList<Board> boardList = boardService.selectBoardTop5();
		return new Gson().toJson(boardList);
	}
	
	private String saveFile(MultipartFile upfile, HttpSession session) {
		//파일명을 변경하여 저장
		//	변경 파일명 => yyyyMMddHHmmss + XXXXX(랜덤값) + .확장자
		// * 현재 날짜 시간 정보
		String currTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		// * 5자리 랜덤값 ( 10000 ~ 99999 )
		int random = (int)(Math.random() * (99999-10000+1)) + 10000;
		// * 확장자 (.txt, .java, .png, ...)
		String orgName = upfile.getOriginalFilename();		// test.png
		String ext = orgName.substring(orgName.lastIndexOf("."));
		
		String chgName = currTime + random + ext;
		
		// 업로드할 파일을 저장할 위치의 물리적인 경로 조회
		String path = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		try {				
			upfile.transferTo(new File(path + chgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return chgName;
	}
}
