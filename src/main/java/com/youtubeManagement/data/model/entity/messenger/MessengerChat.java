package com.youtubeManagement.data.model.entity.messenger;

import com.youtubeManagement.data.enums.ChatType;
import com.youtubeManagement.data.model.entity.RegDtAuditingEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "messenger_chat")
@Getter
@Builder
@AllArgsConstructor
public class MessengerChat extends RegDtAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "TEXT NOT NULL COMMENT '메세지'")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '채팅 타입'")
    private ChatType type;
}
