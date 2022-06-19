package com.example.PetClinic.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class OwnerDto {
    //modellerimizdeki entitylerimizi direkt apilar uzerinden acmak pek dogru olmaz. modellerimizi dısarıya acarken
    // onlara ait Dtolar olusturup bu sekilde sergilememiz daha dogru olur.
    private Long id ;

    String firstname;

    String lastname;

    int phoneNumber;

    List<String> adresses;

    List<String> petList;

    private String owner;
}
