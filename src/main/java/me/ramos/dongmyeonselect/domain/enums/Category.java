package me.ramos.dongmyeonselect.domain.enums;

public enum Category {
    KOREA("한식"),
    JAPAN("일식,돈까스,회"),
    CHINA("중식"),
    WESTERN("양식,아시안"),
    FASTFOOD("패스트푸드"),
    SNACKBAR("분식");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
