package me.ramos.dongmyeonselect.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListResponseDto {

    private Long storeId;
    private String storeName;
    private String location;
    private String contactNum;
    private String storeUrl;
    private String imageUrl;
    private String category;

    private String foodName;
    private int price;
}
