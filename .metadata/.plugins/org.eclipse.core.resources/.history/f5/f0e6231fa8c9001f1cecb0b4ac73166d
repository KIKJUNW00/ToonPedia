package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Comment;
import edu.pnu.persistence.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class commentService {
	
	private final CommentRepository commentRepo;
	
	//댓글쓰기
	public void commentSave(Comment comment) {
		commentRepo.save(comment);
	}
	
	//댓글 가져오기
	public List<Comment> getComments(){
		return commentRepo.findAll();
	}
}
