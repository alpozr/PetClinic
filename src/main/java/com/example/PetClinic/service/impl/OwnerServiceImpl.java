package com.example.PetClinic.service.impl;

import com.example.PetClinic.dto.OwnerDto;
import com.example.PetClinic.entity.Adress;
import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.repository.AdressRepository;
import com.example.PetClinic.repository.OwnerRepository;
import com.example.PetClinic.repository.PetRepository;
import com.example.PetClinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;//RequiredArgsconstructor anotasyonu bunun ıcın constructor olusturacak,
    private final AdressRepository adressRepository;
    private final PetRepository petRepository;

    @Override
    public OwnerDto save(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setFirstName(ownerDto.getFirstname());
        owner.setLastName(ownerDto.getLastname());
        owner.setPhoneNumber(ownerDto.getPhoneNumber());
        final Owner ownerdb = ownerRepository.save(owner);

        List<Pet> petList= new ArrayList<>();
        ownerDto.getPetList().forEach(item->{
            Pet pet=new Pet();
            pet.setPetName(item);
            pet.setOwnerr(ownerDto.getFirstname());
            pet.setOwner(ownerdb);//petlist getiriyor.
            petList.add(pet);
        });
        petRepository.saveAll(petList);

        List<Adress> adressList= new ArrayList<>();
        ownerDto.getAdresses().forEach(item->{
            Adress adres=new Adress();
            adres.setAdress(item);
            adres.setAdressType(Adress.AdressType.OTHER);
            adres.setOwner(ownerdb);
            adressList.add(adres);
        });
        adressRepository.saveAll(adressList);
        ownerDto.setId(ownerdb.getId());
        return ownerDto;

    }

    @Override
    public void delete(Long id) {
            ownerRepository.deleteById(id);
    }

    @Override
    public List<OwnerDto> getAll() {
        List<Owner> owners = ownerRepository.findAll();
        List<OwnerDto> ownerDtos=new ArrayList<>();

        owners.forEach(item->{
              OwnerDto ownerDto = new OwnerDto();
              ownerDto.setPhoneNumber(item.getPhoneNumber());
              ownerDto.setFirstname(item.getFirstName());
              ownerDto.setLastname(item.getLastName());
              ownerDto.setId(item.getId());
              ownerDto.setPetList(item.getPetList().stream()
                      .map(Pet::getPetName)
                      .collect(Collectors.toList()));

              ownerDto.setAdresses(item.getAdresses()
                      .stream().map(Adress::getAdress)
                      .collect(Collectors.toList()));
              ownerDtos.add(ownerDto);
        });
        return ownerDtos;
    }
}
