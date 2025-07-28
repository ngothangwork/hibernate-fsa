package fa.training.services.impl;

import fa.training.dtos.SupplierDTO;
import fa.training.entities.Supplier;
import fa.training.repositories.SupplierRepository;
import fa.training.services.SupplierSerivce;
import fa.training.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;

public class SupplierServiceImpl implements SupplierSerivce {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper = ModelMapperUtil.getModelMapper();

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createSupplier(String name, String email, String phoneNumber, String address) {
        Supplier supplier = new Supplier(name, email, phoneNumber, address);
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Long id, String name, String address) {
        Supplier supplier = supplierRepository.findById(id);
        if (supplier != null) {
            supplier.setName(name);
            supplier.setAddress(address);
            supplierRepository.update(supplier);
        }
    }


    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id);
        if(supplier != null){
            supplierRepository.delete(supplier);
        }
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id);
        if(supplier != null){
            return modelMapper.map(supplier, SupplierDTO.class);
        }else{
            return null;
        }
    }
}
