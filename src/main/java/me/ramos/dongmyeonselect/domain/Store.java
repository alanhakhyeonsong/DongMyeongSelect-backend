package me.ramos.dongmyeonselect.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ramos.dongmyeonselect.domain.enums.Category;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private String location; // 수정가능
    private String contactNum; // 수정가능
    private String storeUrl;
    private String imageUrl;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    public void updateStore(String location, String contactNum) {
        this.location = location;
        this.contactNum = contactNum;
    }
}
