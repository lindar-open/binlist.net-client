package lindar.binlistnet.model;

import lombok.Data;

@Data
public class CardCountry {
    private String numeric;
    private String alpha2;
    private String name;
    private String emoji;
    private String currency;
    private Long   latitude;
    private Long   longitude;
}
