package com.strongyjblog.api.domain.post.entity;

import com.strongyjblog.api.domain.common.entity.File;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("post")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_file_post_file"))
@Entity
public class FilePost extends File {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false, foreignKey = @ForeignKey(name = "FK_file_post_post"))
    private Post post;
}
