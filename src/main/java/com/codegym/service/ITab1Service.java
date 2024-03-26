package com.codegym.service;

import com.codegym.model.Tab1;

import java.util.Optional;

public interface ITab1Service extends IGeneralService<Tab1> {
    Optional<Tab1> findAllByTab2_Id(Long id);
}
