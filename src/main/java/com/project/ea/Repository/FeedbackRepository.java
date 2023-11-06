package com.project.ea.Repository;

import com.project.ea.model.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
    List<Feedback> findByAlumniId(Long alumniId);
}
//    Feedback saveFeedback(Feedback feedback);
//    Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback);
//    void deleteFeedback(Long feedbackId);
//    List<Feedback> findByAlumniId(Long alumniId);