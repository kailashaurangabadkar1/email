package com.example.email.service;

import com.example.email.entity.EmailLog;
import com.example.email.entity.Segment;
import com.example.email.entity.UserEmailRequest;
import com.example.email.repository.EmailLogRepository;
import com.example.email.repository.SegmentRepository;
import com.example.email.repository.UserEmailRequestRepository;
import com.example.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    UserEmailRequestRepository userEmailRequestRepository;
    @Autowired
    SegmentRepository segmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailLogRepository emailLogRepository;

    @Transactional
    public UserEmailRequest saveUserRequest(UserEmailRequest userEmailRequest){
        Optional<Segment>  segment= segmentRepository.findById(userEmailRequest.getSegment_id());
        if (segment.isPresent()){
            segment.get().getUserSegment().forEach(user ->{
                    emailLogRepository.save(new EmailLog("INITIATED", userEmailRequest.getCreatedBy(), userEmailRequest.getId(), user.getId(), user.getEmail()));
                });
                return userEmailRequestRepository.save(userEmailRequest);
        }
        return null;
    }
}
