package com.kh.myEditor.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.myEditor.board.model.vo.Board;
import com.kh.myEditor.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/board")
	public String showEnrollBoard() {
		return "board/enrollBoard";
	}
	
	@PostMapping("/board")
	@ResponseBody
	public String insertBoard(Board board) {
		log.info("data --> {}", board);
		boardService.insertBoard(board);
		
		return "ok";
	}
	
	@PostMapping(value="/upload", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String uploadImage(@RequestPart(value="imgList", required = false) List<MultipartFile>  imgList) {
		log.info("data --> {}", imgList);
		
		List<String> changeNameList = new ArrayList<String>();
		
		for(MultipartFile file : imgList) {
			String changeName = saveFile(file);
			log.info(changeName);
			changeNameList.add(changeName);
		}
		
		
		return new Gson().toJson(changeNameList);
	}
	
	private String saveFile(MultipartFile upfile) {
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
		String uploadDir = "./uploads/";
		Path savePath = Paths.get(uploadDir + chgName);
		
		try {				
			Files.createDirectories(savePath.getParent());
			Files.write(savePath, upfile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uploadDir + chgName;
	}
}

