package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberLoginService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		//memRepo에서 사용자 정보를 검색해서 
				Member member = memRepo.findById(userId)
						.orElseThrow(()->new UsernameNotFoundException("Not Found"));
				
				//UserDetails 타임의 객체를 생성해서 리턴(o.s.s.core.userdetails.User)
				//여기에서 리턴된 User 객체와 로그인 요청 정보를 비교한다.
				return new User(member.getUserId(),member.getPassword(),
						AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
	
//	유저 회원가입 정보 저장(회원가입)
	public void memSave(Member member) {
		member.setPassword(encoder.encode(member.getPassword()));
		member.setRole(Role.ROLE_USER);
		memRepo.save(member);
	}
}
