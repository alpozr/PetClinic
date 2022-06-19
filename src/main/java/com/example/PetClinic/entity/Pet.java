package com.example.PetClinic.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"id"} )
@ToString
public class Pet implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_ownerpet",allocationSize = 1)
    @GeneratedValue(generator = "seq_ownerpet",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name = "petName")
    String petName;
    @Column(length = 500,name = "petAge")
    private int petAge;
    @Column(length = 500,name = "petType")
    String petType;
    @Column(length = 500,name="ownerr" )
    String ownerr;

    @ManyToOne
    @JoinColumn(name = "owner_pet_id")
    private Owner owner;


}
