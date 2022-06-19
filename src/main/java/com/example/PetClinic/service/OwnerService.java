package com.example.PetClinic.service;

import com.example.PetClinic.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    OwnerDto save(OwnerDto OwnerDto);

    void delete(Long id);

    List<OwnerDto> getAll();


}
