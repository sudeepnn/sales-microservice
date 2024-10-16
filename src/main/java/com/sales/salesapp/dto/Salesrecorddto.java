package com.sales.salesapp.dto;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.sales.salesapp.entity.SalesRecord;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salesrecorddto {
	@Id
	private Long id;
	@NotBlank(message = "Manufacture company is mandatory")
    private String manufacturecompany;

    @NotBlank(message = "Model is mandatory")
    private String model;

    @NotBlank(message = "Year is mandatory")
    @Pattern(regexp = "\\d{4}", message = "Year must be a valid 4-digit year")
    private String year;

    @NotBlank(message = "Color is mandatory")
    private String color;

    @NotBlank(message = "Mileage is mandatory")
    private String mileage;

    @Positive(message = "Price must be a positive number")
    private long price;

    @NotBlank(message = "Engine type is mandatory")
    private String engineType;

    @NotBlank(message = "Transmission type is mandatory")
    private String transmission;

    @NotBlank(message = "Fuel efficiency is mandatory")
    private String fuelEfficiency;

    @NotBlank(message = "Availability status is mandatory")
    private String availablestatus;

    @NotEmpty(message = "Features cannot be empty")
    private List<String> features;

    @NotBlank(message = "Manufacture date is mandatory")
    private String manufactureddate;

    @NotBlank(message = "Description is mandatory")
    private String discription;

    @NotBlank(message = "Wheel type is mandatory")
    private String wheeltype;

    @Min(value = 0, message = "Airbags must be a non-negative number")
    private int airbags;
}
