package com.project.ea.service;


import com.project.ea.repository.FeedbackRepository;

import com.project.ea.model.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository feedbackRepository;




//    @Override
//    public Feedback addFeedbackByAlumniId(Long alumniId, Feedback feedback) {
//        Alumni alumni = alumniRepository.findById(alumniId)
//                .orElseThrow(() -> new IllegalArgumentException("Alumni not found"));
//
//        feedback.setAlumni(alumni);
//        Feedback savedFeedback = feedbackRepository.save(feedback);
//        alumni.getFeedbackList().add(savedFeedback); // Maintain the bidirectional relationship
//        alumniRepository.save(alumni); // Update Alumni to reflect the relationship change
//
//        return savedFeedback;
//    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found"));


        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
      feedbackRepository.deleteById(feedbackId);
    }

    @Override
    public List<Feedback> findByAlumniId(Long alumniId) {
        if (alumniId == null) {
            throw new IllegalArgumentException("Alumni ID is required.");
        }

        List<Feedback> feedbackList = feedbackRepository.findByAlumniId(alumniId);
        if (feedbackList.isEmpty()) {
            throw new RuntimeException("No feedback found for Alumni with ID: " + alumniId);
        }

        return feedbackList;
    }


}

