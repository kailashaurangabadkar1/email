package com.example.email.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Segment {
    private @Id @GeneratedValue Long id;
    private String segmentName;
    private String segmentValue;
    private String segmentDescription;
    @ManyToMany
    @JoinTable(
            name = "USER_SEGMENT",
            joinColumns = @JoinColumn(name = "segment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> userSegment;

    public Segment(String segmentName, String segmentValue, String segmentDescription) {
        this.segmentName = segmentName;
        this.segmentValue = segmentValue;
        this.segmentDescription = segmentDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getSegmentValue() {
        return segmentValue;
    }

    public void setSegmentValue(String segmentValue) {
        this.segmentValue = segmentValue;
    }

    public String getSegmentDescription() {
        return segmentDescription;
    }

    public void setSegmentDescription(String segmentDescription) {
        this.segmentDescription = segmentDescription;
    }

    public Set<User> getUserSegment() {
        return userSegment;
    }

    public void setUserSegment(Set<User> userSegment) {
        this.userSegment = userSegment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Objects.equals(id, segment.id) &&
                Objects.equals(segmentName, segment.segmentName) &&
                Objects.equals(segmentValue, segment.segmentValue) &&
                Objects.equals(segmentDescription, segment.segmentDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, segmentName, segmentValue, segmentDescription);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "id=" + id +
                ", segmentName='" + segmentName + '\'' +
                ", segmentValue='" + segmentValue + '\'' +
                ", segmentDescription='" + segmentDescription + '\'' +
                '}';
    }
}
