package pl.biblioteka.enums;

public enum Category {
    FANTASY("FANTASY"),ADVENTURE("ADVENTURE"),ROMANCE("ROMANCE"),
    MYSTERY("MYSTERY"),HORROR("HORROR"),THRILLER("THRILLER"),
    PARANORMAL("PARANORMAL"),SCI_FI("SCI_FI");

    private final String category;

    Category(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
