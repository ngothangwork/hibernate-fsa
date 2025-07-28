package fa.training.services.impl;

import fa.training.dtos.CustomerDTO;
import fa.training.entities.Customer;
import fa.training.repositories.CustomerRepository;
import fa.training.services.CustomerService;
import fa.training.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper = ModelMapperUtil.getModelMapper();


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(String firstName, String lastName, String phoneNumber, String address) {
        Customer customer = new Customer(firstName, lastName, phoneNumber, address);
        customerRepository.save(customer);

    }

    @Override
    public void updateCustomer(Long id, String firstName, String lastName, String phoneNumber, String address) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhoneNumber(phoneNumber);
            customer.setAddress(address);
            customerRepository.update(customer);
        }

    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            return modelMapper.map(customer, CustomerDTO.class);
        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(cusList -> modelMapper.map(cusList, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
