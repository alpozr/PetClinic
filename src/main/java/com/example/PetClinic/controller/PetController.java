package com.example.PetClinic.controller;


import com.example.PetClinic.dto.PetDto;
import com.example.PetClinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

     private final PetService petService;

    @PostMapping("/save")//kayıt islemi yapacak post mapping actık
    public ResponseEntity<PetDto> save(@RequestBody PetDto petDto){
        return ResponseEntity.ok(petService.save(petDto));
    }
    @GetMapping("/all")//butun petlerimizi getirecek olan metod
    public ResponseEntity<List<PetDto>> getAll(){

        return ResponseEntity.ok(petService.getAll());
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id ){
        petService.delete(id);
        return ResponseEntity.ok("Pet has been deleted");
    }
    @GetMapping("/change/{updatedType}/{updatedAge}/{id}")//butun petlerimizi getirecek olan metod
    public ResponseEntity<String> change(@PathVariable String updatedType , @PathVariable int updatedAge, @PathVariable Long id){
           try {
               petService.change(updatedType, updatedAge, id);
              return ResponseEntity.ok("Pet has been updated!");
           }
          catch (Exception e){
               return ResponseEntity.ok("Something wrong.Please check your variables!");
          }
    }
    @GetMapping("/find/{id}")//butun petlerimizi getirecek olan metod
    public ResponseEntity<String> findById(@PathVariable Long id){
        try{
            return ResponseEntity.ok("Pet : "+ petService.findById(id).getPetName());
        }
        catch (Exception e){
            return ResponseEntity.ok("Couldnt find pet !");
        }

    }
}
