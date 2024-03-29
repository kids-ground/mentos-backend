package com.rokwonk.mentor;

import com.rokwonk.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "corporation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Corporation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "corporation_id")
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String domain;
}
