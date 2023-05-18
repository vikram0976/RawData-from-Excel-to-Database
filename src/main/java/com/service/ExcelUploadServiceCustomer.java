package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.model.Customer;

public class ExcelUploadServiceCustomer {
	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	public static List<Customer> getCustomersDataFromExcel(InputStream inputStream) {
		List<Customer> customers = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("Import data");
			int rowIndex = 0;
			for (Row row : sheet) {
				if (rowIndex == 0) {
					rowIndex++;
					continue;
				}
				Iterator<Cell> cellIterator = row.iterator();
				int cellIndex = 0;
				Customer customer = new Customer();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellIndex) {

					case 0 -> customer.setCustomerName(cell.getStringCellValue());
					case 1 -> customer.setAddressLine1(cell.getStringCellValue());
					case 2 -> customer.setTownCity(cell.getStringCellValue());
					case 3 -> customer.setCounty(cell.getStringCellValue());
					case 4 -> customer.setPostCode(cell.getStringCellValue());
					default -> {
					}
					}
					cellIndex++;
				}
				customers.add(customer);
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		return customers;
	}

}
