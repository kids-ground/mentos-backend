package com.rokwonk.post;

import com.rokwonk.common.entity.BaseTimeEntity;
import com.rokwonk.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 30)
    private String title;

    @Column(length = 30)
    private String tags;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ColumnDefault("0")
    private Integer hit;

    private Integer commentCount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id")
    private List<Comment> commentList;
}
