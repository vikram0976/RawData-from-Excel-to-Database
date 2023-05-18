package com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.model.Customer;
import com.repo.CustomerRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	
	 private CustomerRepo customerRepository;

	    public void saveCustomersToDatabase(MultipartFile file){
	        if(ExcelUploadServiceCustomer.isValidExcelFile(file)){
	            try {
	                List<Customer> customers = ExcelUploadServiceCustomer.getCustomersDataFromExcel(file.getInputStream());
	                this.customerRepository.saveAll(customers);
	            } catch (IOException e) {
	                throw new IllegalArgumentException("The file is not a valid excel file");
	            }
	        }
	    }

	    public List<Customer> getCustomers(){
	        return customerRepository.findAll();
	    }
	
}
