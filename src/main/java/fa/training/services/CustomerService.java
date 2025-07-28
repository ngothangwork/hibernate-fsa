package fa.training.services;

import fa.training.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void createCustomer(String firstName, String lastName, String phoneNumber, String address);
    void updateCustomer(Long id, String firstName, String lastName, String phoneNumber, String address);
    void deleteCustomer(Long id);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();

}
