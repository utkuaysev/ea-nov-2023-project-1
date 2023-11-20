package com.project.business.repository;

import com.project.business.model.type.RoleType;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleTypeRepository extends ListCrudRepository<RoleType, Long> {
}
