package edu.pnu.domain.dto;


import java.util.Date;

import edu.pnu.domain.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CommentDTO {
    private Long id;
    
    private Long community_id;
    
    private String nickName;
    
    private Integer likes;
    
    private Date createDate;

	private String content;
    
	// 기본 생성자
    public CommentDTO() {}
	
    public CommentDTO(Comment comment) {
    	this.id = comment.getId();
		this.nickName = comment.getMember().getNickName();
		this.community_id = comment.getCommunity().getId();
		this.content = comment.getContent();
		this.likes = comment.getLikes();
		this.createDate = comment.getCreateDate();
	}
}
