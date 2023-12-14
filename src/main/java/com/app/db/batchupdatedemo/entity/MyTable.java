package com.app.db.batchupdatedemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Table(name = "MY_TABLE")
@Entity
@Data
@NoArgsConstructor
public class MyTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "MY_TABLE_SEQ", initialValue = 1, sequenceName = "MY_TABLE_SEQ", allocationSize = 2)
    private Long id;

    @Column(name = "RID")
    private Long rid;

    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "REVIEW_STATUS")
    private String reviewStatus;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "RECIPIENT")
    private String recipient;

    @Column(name = "IS_MEMBER", columnDefinition = "CHAR(1)")
    private String isMember;

    @Column(name = "NOTIFICATION_STATUS")
    private String notificationStatus;

    @Column(name = "NOTIFICATION_TIME")
    private Date notificationTime;

    @Column(name = "REJECTED_BY")
    private String rejectedBy;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_AT")
    private Date createdAt;
}
