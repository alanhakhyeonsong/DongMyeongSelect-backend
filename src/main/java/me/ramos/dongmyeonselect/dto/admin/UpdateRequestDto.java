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
public class UpdateRequestDto {
    private Long storeId;
    // Store
    private String location;
    private String contactNum;

    // Menu
    private String foodName;
    private int price;
}
