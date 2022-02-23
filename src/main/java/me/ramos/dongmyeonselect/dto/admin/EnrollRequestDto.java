package me.ramos.dongmyeonselect.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollRequestDto {
    // Store
    @NotEmpty(message = "필수 입력 값입니다.")
    private String storeName;
    @NotEmpty(message = "필수 입력 값입니다.")
    private String location;
    @NotEmpty(message = "필수 입력 값입니다.")
    private String contactNum;
    @NotEmpty(message = "필수 입력 값입니다.")
    private String storeUrl;
    @NotEmpty(message = "필수 입력 값입니다.")
    private String imageUrl;
    private String category;

    // Menu
    @NotEmpty(message = "필수 입력 값입니다.")
    private String foodName;
    private int price;
}
