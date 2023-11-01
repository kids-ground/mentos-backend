package com.rokwonk.mentor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "job_group")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobGroup {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "job_group_id")
    private Long id;

    @Column(length = 30)
    private String name;
}
