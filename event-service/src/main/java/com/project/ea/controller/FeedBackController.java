package com.project.ea.controller;

import com.project.ea.dto.get.GetAFullFeedbackDto;
import com.project.ea.dto.post.PostFullFeedbackDto;
import com.project.ea.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedBackController {
    private final FeedbackService feedbackService;
    @GetMapping
    public List<GetAFullFeedbackDto> getAllFeedbacks(){
        return feedbackService.getAllFeedBacks();
    }
    @PostMapping()
    public GetAFullFeedbackDto saveFeedback(PostFullFeedbackDto postFullFeedbackDto){
        return  feedbackService.saveFeedback(postFullFeedbackDto);
    }
      @PutMapping("/{id}")
      public GetAFullFeedbackDto updateFeedback(@PathVariable Long id, @RequestBody PostFullFeedbackDto updatedPostFullFeedbackDto){
        return feedbackService.updateFeedback(id,updatedPostFullFeedbackDto);
    }
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
     @GetMapping("/alumni-id")
     public List<GetAFullFeedbackDto> findByAlumniId(@RequestParam Long id){
        return feedbackService.findByAlumniId(id);
     }
}
