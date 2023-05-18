package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Supply;
import com.service.SupplyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("supplys")
public class SupplyController {
    private SupplyService supplyService;

    @PostMapping("/upload-supply-data")
    public ResponseEntity<?> uploadSupplysData(@RequestParam("file")MultipartFile file){
        this.supplyService.saveSupplysToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Supplys data uploaded and saved to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Supply>> getSupplys(){
        return new ResponseEntity<>(supplyService.getSupplys(), HttpStatus.FOUND);
    }
}