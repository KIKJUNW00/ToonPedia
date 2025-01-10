package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Community;

public interface CommunityRepository extends JpaRepository<Community, Long>{
	 List<Community> findAllByOrderByCreateDateDesc(); // 날짜 내림차순
}
