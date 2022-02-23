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
public class UpdateRequestDto {
    private Long storeId;
    // Store
    @NotEmpty(message = "필수 입력 값입니다.")
    private String location;
    @NotEmpty(message = "필수 입력 값입니다.")
    private String contactNum;

    // Menu
    @NotEmpty(message = "필수 입력 값입니다.")
    private String foodName;
    private int price;
}
