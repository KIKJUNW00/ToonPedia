package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberLoginService;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
	
	private final MemberLoginService memberLoginService;
	private final MemberService memService;
	
	//회원가입
		@GetMapping("/join")
		public void join() {
			
		}
	
	//회원가입후 이동페이지
		@PostMapping("/join")
		//requestbody는 react처리 위해 사용
		public String joinProc(@RequestBody Member member) {
			
			memberLoginService.memSave(member);
			return "";
		}
	
	//멤버 목록 가져오기
	@GetMapping("/members")
	public ResponseEntity<?> getMember(){
		return ResponseEntity.ok(memService.getMembers());
	}
}
