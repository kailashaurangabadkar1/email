package com.example.email.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;

@Entity
public class EmailLog {
    private @Id
    @GeneratedValue
    Long id;
    private Long userEmailRequestId;
    private Long userId;
    private String userEmail;
    private LocalDateTime triggerTime;
    private LocalDateTime sentTime;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;

    public EmailLog(LocalDateTime triggerTime, LocalDateTime sentTime, String status, String createdBy, LocalDateTime createdAt) {
        this.triggerTime = triggerTime;
        this.sentTime = sentTime;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public EmailLog(String status, String createdBy, Long userEmailRequestId, Long userId, String userEmail) {

        this.status = status;
        this.createdBy = createdBy;
        this.userEmailRequestId = userEmailRequestId;
        this.userId=userId;
        this.userEmail=userEmail;
        LocalDateTime currentTime = now();
        this.createdAt = currentTime;
        this.triggerTime = currentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserEmailRequestId() {
        return userEmailRequestId;
    }

    public void setUserEmailRequestId(Long userEmailRequestId) {
        this.userEmailRequestId = userEmailRequestId;
    }

    public LocalDateTime getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailLog emailLog = (EmailLog) o;
        return Objects.equals(id, emailLog.id) &&
                Objects.equals(triggerTime, emailLog.triggerTime) &&
                Objects.equals(sentTime, emailLog.sentTime) &&
                Objects.equals(status, emailLog.status) &&
                Objects.equals(createdBy, emailLog.createdBy) &&
                Objects.equals(createdAt, emailLog.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, triggerTime, sentTime, status, createdBy, createdAt);
    }

    @Override
    public String toString() {
        return "EmailLog{" +
                "id=" + id +
                ", triggerTime=" + triggerTime +
                ", sentTime=" + sentTime +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
