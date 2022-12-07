package model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Towar {
    @NonNull
    private String nazwa;
    @NonNull
    private double cenaNetto;
}
