package com.ginkgooai.core.mcp.contractor.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

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

    @Schema(description = "The county name")
    private String county;

    @Schema(description = "The city name")
    private String city;

    @Schema(description = "The state code")
    private String state;

    @Schema(description = "The zip code")
    private String zip;


    @Schema(description = "Phone number")
    private String phoneNumber;

    @Schema(description = "Issue date")
    private String issueDate;

    @Schema(description = "Expiration date")
    private String expirationDate;

    @Schema(description = "Last updated date")
    private String lastUpdated;

    @Schema(description = "The latitude in degrees")
    private Double geoLat;
    @Schema(description = "The last updated date")
    private Double geoLng;

    @Schema(description = "The data source")
    private String dataSource;

    @Schema(description = "The status")
    private String status;

    @Hidden
    private String classification;

    @Schema(description = "The classification array")
    private List<String> classificationArray;

}