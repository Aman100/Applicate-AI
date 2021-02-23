package com.applicateAI.cool.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applicateAI.cool.model.*;
import com.applicateAI.cool.repository.*;
import java.util.*;

@Service
public class SupplierService
{
@Autowired
private SupplierRepository supplierRepository;

public void save(Supplier supplier)
{
supplierRepository.save(supplier);
}

public Iterable<Supplier> findAll()
{
return supplierRepository.findAll();
}
}