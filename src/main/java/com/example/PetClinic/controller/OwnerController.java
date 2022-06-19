package com.example.PetClinic.controller;


import com.example.PetClinic.dto.OwnerDto;
import com.example.PetClinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

        private final OwnerService ownerService;
        @PostMapping("/save")
        public ResponseEntity<OwnerDto> save(@RequestBody OwnerDto ownerDto){
            return ResponseEntity.ok(ownerService.save(ownerDto));
        }
        @GetMapping()
          public ResponseEntity<List<OwnerDto>> getAll(){
          return ResponseEntity.ok(ownerService.getAll());
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id ){
            try {
                ownerService.delete(id);
                return ResponseEntity.ok("Owner has been deleted");
            }
            catch(Exception e) {
                return ResponseEntity.ok("Couldnt find id,please write correct id!");
            }
    }


}
