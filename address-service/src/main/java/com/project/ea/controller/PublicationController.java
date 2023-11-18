package com.project.ea.controller;

import com.project.ea.service.PublicationService;
import com.project.ea.model.Publication;
import com.project.ea.model.type.PublicationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/publications")
public class PublicationController {
    private final PublicationService publicationService;

      @GetMapping("/{id}")
    public Publication getById(@PathVariable long id){
        return publicationService.getById(id);
    }
  @PutMapping("/{id}")
    public Publication updateById(@PathVariable long id, @RequestBody Publication publication){
         return  publicationService.updateById(id, publication);
  }

    @PostMapping()
       public Publication addPublication(@RequestBody Publication publication){
          return publicationService.addPublication(publication);
    }
   @GetMapping("/type")
    public List<Publication> findAllByPublicationType(@RequestParam PublicationType type){
          return publicationService.findAllByPublicationType(type );
    }

}
