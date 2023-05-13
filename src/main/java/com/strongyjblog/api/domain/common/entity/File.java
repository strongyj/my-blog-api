package com.strongyjblog.api.domain.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Entity
public abstract class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String savedName;
}
