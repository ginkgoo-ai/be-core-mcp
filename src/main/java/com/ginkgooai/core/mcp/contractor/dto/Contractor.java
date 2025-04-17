package com.ginkgooai.core.mcp.contractor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about a Contractor")

public class Contractor {

    @Schema(description = "The Contractor ID")
    private String id;

    @Schema(description = "The license number")
    private String licenseNumber;

    @Schema(description = "The business type")
    private String businessType;

    @Schema(description = "The business name")
    private String businessName;

    @Schema(description = "The address line")
    private String address;

    @Schema(description = "The city name")
    private String city;

    @Schema(description = "The county name")
    private String county;

    @Schema(description = "The State code")
    private String state;

    @Schema(description = "The zip code")
    private String zip;


    @Schema(description = "The phone number")
    private String phoneNumber;

    @Schema(description = "The issue date")
    private String issueDate;

    @Schema(description = "The Expiration date")
    private String expirationDate;


    @Schema(description = "The last updated date")
    private String lastUpdated;

    @Schema(description = "The latitude in degrees")
    private Double geoLat;
    @Schema(description = "The last updated date")
    private Double geoLng;

    @Schema(description = "The data source")
    private String dataSource;

    @Schema(description = "The classification")
    private String classification;

    @Schema(description = "The status")
    private String status;

    @Schema(description = "The classification array")
    private List<String> classificationArray;

    @Schema(description = "The created at")
    private Timestamp createdAt;

    @Schema(description = "The updated at")
    private Timestamp updatedAt;

    @Schema(description = "The created by")
    private String createdBy;

    @Schema(description = "The updated by")
    private String updatedBy;

    @Schema(description = "The distance to given gps point")
    private BigDecimal distance;

}