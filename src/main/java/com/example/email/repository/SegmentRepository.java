package com.example.email.repository;

import com.example.email.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SegmentRepository extends JpaRepository<Segment, Long> {

    List<Segment> findBySegmentNameAndSAndSegmentValue(String segmentName, String segmentValue);
}
