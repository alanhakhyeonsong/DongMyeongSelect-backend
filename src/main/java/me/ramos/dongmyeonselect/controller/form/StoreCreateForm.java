package me.ramos.dongmyeonselect.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StoreCreateForm {
    @NotBlank(message = "필수 입력 값입니다.")
    private String storeName;
    @NotBlank(message = "필수 입력 값입니다.")
    private String location;
    @NotBlank(message = "필수 입력 값입니다.")
    private String contactNum;
    @NotBlank(message = "필수 입력 값입니다.")
    private String storeUrl;
    @NotBlank(message = "필수 입력 값입니다.")
    private String imageUrl;
    private String category;

    // Menu
    @NotBlank(message = "필수 입력 값입니다.")
    private String foodName;
    private int price;
}
