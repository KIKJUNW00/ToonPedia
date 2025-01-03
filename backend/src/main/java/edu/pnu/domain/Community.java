package edu.pnu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOARD")
public class Community {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // 다대일 관계 설정
    @JoinColumn(name = "user_Id") // 외래 키 컬럼 이름 설정 
    private Member member; // Member 엔티티 참조
    
    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    
    private String title;
    private String content;
    
    
    @Column(nullable = false)
    private Integer likes = 0;	//좋아요
    @Column(nullable = false)
    private Integer hit = 0;	//조회수

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createDate = new Date();
}
	