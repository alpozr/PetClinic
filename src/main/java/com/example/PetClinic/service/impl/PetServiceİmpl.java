package com.example.PetClinic.service.impl;

import com.example.PetClinic.dto.PetDto;
import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.repository.PetRepository;
import com.example.PetClinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceİmpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public PetDto save(PetDto petDto) {
        Pet pet = new Pet();
        pet.setPetName(petDto.getPetName());
        pet.setPetAge(petDto.getPetAge());
        pet.setOwnerr(petDto.getPetOwnerr());
        pet.setPetType(petDto.getPetType());
        petRepository.save(pet);

        return petDto;

    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
       return petRepository.findById(id).get();
    }

    @Override
    public void change(String updatedType, int updatedAge, Long id) {
        Pet petdb = petRepository.findById(id).get();
        petdb.setPetAge(updatedAge);
        petdb.setPetType(updatedType);
        petRepository.save(petdb);
    }

    @Override
    public List<PetDto> getAll() {
        List<Pet> pets = petRepository.findAll();
        List<PetDto> petDtos=new ArrayList<>();

        pets.forEach(it->{
            PetDto petDto= new PetDto();
            petDto.setId(it.getId());
            petDto.setPetAge(it.getPetAge());
            petDto.setPetName(it.getPetName());
            petDto.setPetOwnerr(it.getOwnerr());
            petDto.setPetType(it.getPetType());
            petDtos.add(petDto);
        });
        return petDtos;
    }
}
