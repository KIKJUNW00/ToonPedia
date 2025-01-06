package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

}
