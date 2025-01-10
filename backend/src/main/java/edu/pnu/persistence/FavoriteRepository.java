package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Favorite;
import edu.pnu.domain.dto.FavoriteDTO;
import java.util.List;
import java.util.Optional;

import edu.pnu.domain.Member;



public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	
	Optional<Favorite> findByCodeAndMemberUserId(String code, String userId);

}
