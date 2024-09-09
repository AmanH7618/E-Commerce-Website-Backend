package com.customer.customer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        var customer = repo.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = repo.findById(request.id()).orElseThrow(()-> new CustomerNotFound(format("Cannot update :: customer is not found")));
        mergerCustomer( customer ,request);
        repo.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setFirstname(request.email());
        }if(request.adress()!=null){
            customer.setAdress(request.adress());
        }


    }

    public List<CustomerResponse> findAllCustomer() {
        return repo.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existByID(String customerId) {
        return repo.findById(customerId).isPresent();
    }

    public CustomerResponse findByID(String customerId) {
        return repo.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(()->new CustomerNotFound(format("No customer found")));
    }

    public void deletecustomer(String customerId) {
        repo.deleteById(customerId);
    }
}
