package com.codegym.repository;

import com.codegym.model.Tab1;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface ITab1Repository extends CrudRepository<Tab1, Long> {
    Optional<Tab1> findAllByTab2_Id(Long id);
}
