package com.example.PetClinic.dto;

import com.example.PetClinic.entity.Owner;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
public class PetDto {
    //modellerimizdeki entitylerimizi direkt apilar uzerinden acmak pek dogru olmaz. modellerimizi dısarıya acarken
    // onlara ait Dtolar olusturup bu sekilde sergilememiz daha dogru olur.

    private Long id;

    private String petName;

    private int petAge;

    private String petType;




    private String petOwnerr;
}

