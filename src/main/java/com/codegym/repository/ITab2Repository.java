package com.codegym.repository;

import com.codegym.model.Tab2;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ITab2Repository extends CrudRepository<Tab2, Long> {
}
