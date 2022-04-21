package com.example.email.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;

@Entity
public class UserEmailRequest {
    private @Id
    @GeneratedValue
    Long id;
    private Long segment_id;
    private Long template_id;
    private String sender;
    private String toRecipient;
    private String ccRecipient;
    private String bccRecipient;
    private String createdBy;
    private LocalDateTime createdAt;

    public UserEmailRequest(Long segment_id, Long template_id, String sender, String toRecipient, String ccRecipient, String bccRecipient, String createdBy) {
        this.segment_id = segment_id;
        this.template_id = template_id;
        this.sender = sender;
        this.toRecipient = toRecipient;
        this.ccRecipient = ccRecipient;
        this.bccRecipient = bccRecipient;
        this.createdBy= createdBy;
        this.createdAt = now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(Long segment_id) {
        this.segment_id = segment_id;
    }

    public Long getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Long template_id) {
        this.template_id = template_id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getToRecipient() {
        return toRecipient;
    }

    public void setToRecipient(String toRecipient) {
        this.toRecipient = toRecipient;
    }

    public String getCcRecipient() {
        return ccRecipient;
    }

    public void setCcRecipient(String ccRecipient) {
        this.ccRecipient = ccRecipient;
    }

    public String getBccRecipient() {
        return bccRecipient;
    }

    public void setBccRecipient(String bccRecipient) {
        this.bccRecipient = bccRecipient;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmailRequest that = (UserEmailRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(segment_id, that.segment_id) &&
                Objects.equals(template_id, that.template_id) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(toRecipient, that.toRecipient) &&
                Objects.equals(ccRecipient, that.ccRecipient) &&
                Objects.equals(bccRecipient, that.bccRecipient) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, segment_id, template_id, sender, toRecipient, ccRecipient, bccRecipient, createdBy, createdAt);
    }

    @Override
    public String toString() {
        return "UserEmailRequest{" +
                "id=" + id +
                ", segment_id=" + segment_id +
                ", template_id=" + template_id +
                ", sender='" + sender + '\'' +
                ", toRecipient='" + toRecipient + '\'' +
                ", ccRecipient='" + ccRecipient + '\'' +
                ", bccRecipient='" + bccRecipient + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
