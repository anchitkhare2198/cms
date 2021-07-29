package com.example.cms.controller;

import com.example.cms.exceptions.CustomerNotFound;
import com.example.cms.model.Customer;
import com.example.cms.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {

    @Autowired
    private CustomerRepo customerRepo;;

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @PostMapping(value = "/saveCustomers")
    public String saveCustomers(@RequestBody Customer customer){
        customerRepo.save(customer);
        return "Saved...";
    }

    @GetMapping(value = "/getCustomer/{id}")
    public Customer getCustomerByID(@PathVariable long id){
        Optional<Customer> chosenCustomer = customerRepo.findById(id);
        if(!chosenCustomer.isPresent()){
            throw new CustomerNotFound("Customer Record not available");
        }
        return chosenCustomer.get();
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        Customer updatedCustomer = customerRepo.findById(id).get();
        updatedCustomer.setCus_firstName(customer.getCus_firstName());
        updatedCustomer.setCus_lastName(customer.getCus_lastName());
        updatedCustomer.setCus_Email(customer.getCus_Email());
        return customerRepo.save(updatedCustomer);
        //return "Updated...";

    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable long id){
        Customer deleteCustomer = customerRepo.findById(id).get();
        customerRepo.delete(deleteCustomer);
        return "Deleted Customer with id : "+id;
    }

}
