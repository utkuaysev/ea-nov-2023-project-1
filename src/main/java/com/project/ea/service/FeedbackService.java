package com.project.ea.service;

import com.project.ea.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback);
    void deleteFeedback(Long feedbackId);
    List<Feedback> findByAlumniId(Long alumniId);
}
