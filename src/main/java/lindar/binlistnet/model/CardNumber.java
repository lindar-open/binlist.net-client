package lindar.binlistnet.model;

import lombok.Data;

@Data
public class CardNumber {
    private Long    length;
    private boolean luhn;
}
