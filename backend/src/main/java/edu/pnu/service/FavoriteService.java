package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Favorite;
import edu.pnu.domain.Member;
import edu.pnu.domain.dto.FavoriteDTO;
import edu.pnu.persistence.FavoriteRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FavoriteService {
	private final FavoriteRepository favoriteRepo;
	private final MemberRepository memberRepo;
	
	//관심웹툰 저장
	public FavoriteDTO favoriteWebtoons(FavoriteDTO dto, String username) {
		Member member = memberRepo.findById(username).get();
		
		// 중복 체크: 웹툰 코드와 회원 ID로 확인
	    Optional<Favorite> existingFavorite = favoriteRepo.findByCodeAndMemberUserId(dto.getCode(), username);

	    if (existingFavorite.isPresent()) {
	        throw new IllegalArgumentException("이미 등록된 관심 웹툰입니다.");
	    }
		
		Favorite f = new Favorite();
		
		f.setCode(dto.getCode());
		f.setPicture(dto.getPicture());
		f.setName(dto.getName());
		f.setMember(member);
		
		f = favoriteRepo.save(f);
		
		return new FavoriteDTO(f);
	}
	
//	유저별 관심웹툰 찾아서 뿌리기
	public List<FavoriteDTO> UserFavorite(String username) {
		System.out.println("@@@@@@@@@@@@@@@@@@"+username);
		
		Member member = memberRepo.findById(username).get();
		
		List<Favorite> list = member.getFavorites();
		
		List<FavoriteDTO> ret = new ArrayList<>();
		for(Favorite f : list) {
			ret.add(new FavoriteDTO(f));
		}
		
		return ret;
		
	}
	
//	관심웹툰 삭제
	public void deleteFavorite(FavoriteDTO dto, String userId) {
	    Favorite favorite = favoriteRepo.findByCodeAndMemberUserId(dto.getCode(), userId)
	            .orElseThrow(() -> new IllegalArgumentException("관심 웹툰을 찾을 수 없습니다."));

	    favoriteRepo.delete(favorite);
	}

	
}














