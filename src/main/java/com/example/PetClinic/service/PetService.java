package com.example.PetClinic.service;


import com.example.PetClinic.dto.PetDto;
import com.example.PetClinic.entity.Pet;

import java.util.List;

public interface PetService {

    PetDto save(PetDto petDto);

    void delete(Long id);

    Pet findById(Long id);

    void change(String updatedType,int updatedAge,Long id);

    List<PetDto> getAll();

}
