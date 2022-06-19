package com.example.PetClinic.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity // Veritabanında tutulacak bir adres oldugundan ve JPA ile calistigimizdan Entity anotasyonu geliyor.
@Table(name = "owner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"id"} ) //idler esitse iki nesne birbirine esittir anotasyonumuz yine lomboktan geliyor.
@ToString
public class Owner implements Serializable {
    @Id
    @SequenceGenerator(name="seq_owneradress",allocationSize = 0)
    @GeneratedValue(generator = "seq_owneradress",strategy = GenerationType.SEQUENCE)
    //Generated value yukarıdaki sequanceden idyi alip asagıdaki long alanındaki idye dolduracaktir.
    //Bunu generate ederken belirtmek durumundayiz,ancak MySQL gibi yapilarda bu oto yapilmaktadır.
    private Long id ;

    @Column(length = 100,   name = "firstName")//Colonumuzun bu olacagini söyledik
    String firstName;
    @Column(length = 100,   name = "lastName")//Colonumuzun bu olacagini söyledik
    String lastName;
    @Column(length = 100,   name = "phoneNumber")//Colonumuzun bu olacagini söyledik
    int phoneNumber;

    //Relational bir veritabanı olacagindan bize join islemleri gerekiyor.

    @OneToMany//Bir kisi birden cok adresi olabileceginden OneToMany anotasyonu kullandik.
    @JoinColumn(name = "owner_adress_id")
    private List<Adress> adresses;

    @OneToMany
    @JoinColumn(name = "owner_pet_id")//Bir kisi birden cok hayvanı olabileceginden OneToMany anotasyonu kullandik.
    private List<Pet> petList;
}
