package target.ProductOwner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import target.ProductOwner.exception.ResourceNotFoundException;
import target.ProductOwner.model.Owner;
import target.ProductOwner.repository.OwnerRepository;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    //build create owner REST API
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner){
        return ownerRepository.save(owner);
    }

    //build get api by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Owner> getEmployeeByID(@PathVariable long id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:" + id));
        return ResponseEntity.ok(owner);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner ownerDetails){
        Owner updateOwner = ownerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:" + id));
        updateOwner.setOwnerName(ownerDetails.getOwnerName());
        updateOwner.setProductName(ownerDetails.getProductName());
        updateOwner.setProductId(ownerDetails.getProductId());

        ownerRepository.save(updateOwner);
        return ResponseEntity.ok(updateOwner);
    }


    //build delete owner REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable long id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:" + id));

        ownerRepository.delete(owner);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
}
