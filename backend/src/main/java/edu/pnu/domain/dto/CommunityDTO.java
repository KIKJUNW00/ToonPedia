package edu.pnu.domain.dto;

import java.util.Date;

import edu.pnu.domain.Community;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CommunityDTO {
    private Long id;

    private String nickName;

    private String title;
    private String content;
    
    
    private Integer likes;	//좋아요
    private Integer hit;	//조회수

    private Date createDate;
    
    public CommunityDTO(Community community) {
    	this.id = community.getId();
		this.nickName = community.getMember().getNickName();
		this.title = community.getTitle();
		this.content = community.getContent();
		this.likes = community.getLikes();
		this.hit = community.getHit();
		this.createDate = community.getCreateDate();
	}

}
