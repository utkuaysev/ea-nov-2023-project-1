package com.project.ea.service;

import com.project.ea.dto.get.GetAFullFeedbackDto;
import com.project.ea.dto.post.PostFullFeedbackDto;

import java.util.List;

public interface FeedbackService {
    List<GetAFullFeedbackDto> getAllFeedBacks();
    GetAFullFeedbackDto getFeedBackById(Long id);
    GetAFullFeedbackDto saveFeedback(PostFullFeedbackDto postFullFeedbackDto);
    GetAFullFeedbackDto updateFeedback(Long feedbackId, PostFullFeedbackDto postFullFeedbackDto);
    void deleteFeedback(Long feedbackId);
    List<GetAFullFeedbackDto> findByAlumniId(Long alumniId);
}
