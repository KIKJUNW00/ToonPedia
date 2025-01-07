package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Comment;
import edu.pnu.domain.Community;
import edu.pnu.domain.Member;
import edu.pnu.domain.dto.CommentDTO;
import edu.pnu.persistence.CommentRepository;
import edu.pnu.persistence.CommunityRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class commentService {
	
	private final CommentRepository commentRepo;
	private final MemberRepository memberRepo;
	private final CommunityRepository commuRepo;
	
	//댓글쓰기
	public CommentDTO commentSave(CommentDTO dto, String username) {
		
		Member member = memberRepo.findById(username).get();
		Community commnity = commuRepo.findById(dto.getCommunity_id()).get();
		Comment comment = new Comment();
		
		
		comment.setMember(member);
		comment.setCommunity(commnity);
		comment.setContent(dto.getContent());
		
		comment = commentRepo.save(comment);
		
		return new CommentDTO(comment);
		
	}
	
	//댓글 모두 가져오기
//	public List<CommentDTO> getComments(){
//		List<Comment> commentList = commentRepo.findAll();
//		
//		List<CommentDTO> ret = new ArrayList<>();
//		
//		for(Comment c : commentList) {
//			ret.add(new CommentDTO(c));
//		}
//		
//		return ret;
//	}
	
//	게시글(id)별 댓글 가져오기
	public List<CommentDTO> getCommentId(Long id) {
		Community community = commuRepo.findById(id).get();
		
		List<Comment> list  = community.getComments();
		
		List<CommentDTO> ret = new ArrayList<>();
		for(Comment c : list) {
			ret.add(new CommentDTO(c));
		}
		
		return ret;
	} 
	
	
	
	
	
	
	
}
