package com.project.ea.service;

import com.project.ea.model.Publication;
import com.project.ea.model.type.PublicationType;

import java.util.List;


public interface PublicationService {
    Publication getById(long id);
    Publication updateById(long id, Publication publication);
    Publication addPublication(Publication publication);
    void deleteById(long id);
    List<Publication> findAllByPublicationType(PublicationType type);

}
