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
import com.model.Supply;

public class ExcelUploadServiceSupply {
	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	public static List<Supply> getSupplysDataFromExcel(InputStream inputStream) {
		List<Supply> supplys = new ArrayList<>();
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
				int cellIndex = 5;
				Supply supply = new Supply();
				Customer customer = new Customer();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellIndex) {

					case 0 -> supply.setCustomerID(customer.getCustomerID());
					case 1 -> supply.setMpan(cell.getStringCellValue());
					case 2 -> supply.setMsn(cell.getStringCellValue());
					case 3 -> supply.setSsc(cell.getStringCellValue());
					case 4 -> supply.setProfileClass((int)cell.getNumericCellValue());
					default -> {
					}
					}
					cellIndex++;
				}
				supplys.add(supply);
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		return supplys;
	}


}
