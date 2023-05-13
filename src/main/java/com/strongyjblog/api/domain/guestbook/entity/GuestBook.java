package com.strongyjblog.api.domain.guestbook.entity;

import com.strongyjblog.api.domain.common.model.BaseTime;
import com.strongyjblog.api.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class GuestBook extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "FK_guest_book_member"))
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id", foreignKey = @ForeignKey(name = "FK_guest_book_guest_book_reply"))
    private GuestBookReply guestBookReply;
}
