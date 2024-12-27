package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.pnu.domain.Community;
import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.CommunityRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class test implements ApplicationRunner{
	private final MemberRepository memRepo;
	private final CommunityRepository commuRepo;
	private final PasswordEncoder encoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		 // Member 객체 생성 및 저장
        Member member = Member.builder()
                .userId("member23")
                .password(encoder.encode("1234"))
                .nickName("홍길동1")
                .snsId(null)
                .role(Role.ROLE_USER)
                .build();
        
        // Member 객체 저장
        memRepo.save(member);


//        for (int i = 0; i < 30; i++) {
//            Community community = Community.builder()
//                    .title("Title " + (i + 1))
//                    .content("Content " + (i + 1))
//                    .member(member)
//                    .likes(0)
//                    .hit(0)
//                    .build();
//            commuRepo.save(community);
            
        System.out.println("@#############"+ member.getNickName());

//	}
	}
}
