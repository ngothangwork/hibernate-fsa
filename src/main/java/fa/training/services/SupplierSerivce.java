package fa.training.services;

import fa.training.dtos.SupplierDTO;

public interface SupplierSerivce {
    void createSupplier(String name, String email, String phoneNumber, String address);
    void updateSupplier(Long id, String name, String address);
    SupplierDTO getSupplierById(Long id);
    void deleteSupplier(Long id);

}
