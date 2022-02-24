package me.ramos.dongmyeonselect.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StoreUpdateForm {
    private Long storeId;
    // Store
    @NotBlank(message = "필수 입력 값입니다.")
    private String location;
    @NotBlank(message = "필수 입력 값입니다.")
    private String contactNum;

    // Menu
    @NotBlank(message = "필수 입력 값입니다.")
    private String foodName;
    private int price;
}
