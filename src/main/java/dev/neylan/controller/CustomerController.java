package dev.neylan.controller;

import dev.neylan.entity.Customer;
import dev.neylan.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/api/customer")
public class CustomerController {

    @Inject
    CustomerService customerService;


    @GET
    public List<Customer> retrieveCustomers(){
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAllCustomers();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    @POST
    @Transactional
    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

}
