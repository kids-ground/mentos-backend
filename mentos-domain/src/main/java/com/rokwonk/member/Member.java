package com.rokwonk.member;

import com.rokwonk.common.entity.BaseTimeEntity;
import com.rokwonk.member.vo.MemberGender;
import com.rokwonk.member.vo.MemberProfileImage;
import com.rokwonk.member.vo.MemberStatus;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 30)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Enumerated(EnumType.STRING)
    private MemberGender memberGender;

    private MemberProfileImage profileImage;

    @Column(columnDefinition = "bit")
    @ColumnDefault("0")
    private Boolean alarmOn;

    @Column(length = 30)
    private String currentCorporationName;

    @Column(length = 30)
    private String currentJobDetail;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="member_id")
    private List<MemberDevice> memberDeviceList;
}
