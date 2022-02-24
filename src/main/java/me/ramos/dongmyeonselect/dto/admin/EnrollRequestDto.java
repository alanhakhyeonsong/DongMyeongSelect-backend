package me.ramos.dongmyeonselect.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollRequestDto {
    // Store
    private String storeName;
    private String location;
    private String contactNum;
    private String storeUrl;
    private String imageUrl;
    private String category;

    // Menu
    private String foodName;
    private int price;
}
