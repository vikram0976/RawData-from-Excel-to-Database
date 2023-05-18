package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer supplyID;
	@NotNull(message= "should not be null")
	@OneToOne
	@JoinColumn(name = "customerID")
    private Integer customerID;
	@NotNull(message= "should not be null")
	@Min(value = 13)
	@Max(value = 13)
    private String mpan;
	@NotNull(message= "should not be null")
    private String msn;
	@NotNull(message= "should not be null")
	@Min(value = 4)
	@Max(value = 4)
	private String ssc;
	@NotNull(message= "should not be null")
	@Min(value = 1)
	@Max(value = 1)
	private Integer profileClass;
	
}
