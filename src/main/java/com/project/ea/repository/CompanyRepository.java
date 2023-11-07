package com.project.ea.repository;

import com.project.ea.model.Address;
import com.project.ea.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ListCrudRepository<Company, Long> {

    @Override
    default void delete(Company company) {
        company.setDeleted(true);
        Address address = company.getAddress();
        if (address != null) {
            address.setDeleted(true);
        }
    }
}
