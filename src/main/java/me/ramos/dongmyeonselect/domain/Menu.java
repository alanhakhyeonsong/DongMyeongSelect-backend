package me.ramos.dongmyeonselect.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    @JsonIgnore
    private Long id;

    private String foodName; // 수정가능
    private int price; // 수정가능

    public void updateMenu(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }
}
