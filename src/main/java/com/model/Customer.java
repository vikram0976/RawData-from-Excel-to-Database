package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
	@NotNull(message= "should not be null")
    private String customerName;
	@NotNull(message= "should not be null")
    private String addressLine1;
	@NotNull(message= "should not be null")
    private String townCity;
	@NotNull(message= "should not be null")
    private String county;
	@NotNull(message= "should not be null")
    private String postCode;
    

}
