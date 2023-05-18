package com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.model.Supply;
import com.repo.SupplyRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplyService {
	
	 private SupplyRepo supplyRepository;

	    public void saveSupplysToDatabase(MultipartFile file){
	        if(ExcelUploadServiceSupply.isValidExcelFile(file)){
	            try {
	                List<Supply> supplys = ExcelUploadServiceSupply.getSupplysDataFromExcel(file.getInputStream());
	                this.supplyRepository.saveAll(supplys);
	            } catch (IOException e) {
	                throw new IllegalArgumentException("The file is not a valid excel file");
	            }
	        }
	    }

	    public List<Supply> getSupplys(){
	        return supplyRepository.findAll();
	    }
	


}
