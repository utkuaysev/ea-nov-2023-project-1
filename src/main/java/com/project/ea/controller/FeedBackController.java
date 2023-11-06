package com.project.ea.controller;

import com.project.ea.service.FeedbackService;
import com.project.ea.model.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedBackController {
    private final FeedbackService feedbackService;
    @PostMapping()
    public Feedback saveFeedback(Feedback feedback){
        return  feedbackService.saveFeedback(feedback);
    }
      @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback){
        return feedbackService.updateFeedback(id,updatedFeedback);
    }
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
     @GetMapping("/alumni/{id}")
      public List<Feedback> findByAlumniId(Long id){
        return feedbackService.findByAlumniId(id);
     }
}
