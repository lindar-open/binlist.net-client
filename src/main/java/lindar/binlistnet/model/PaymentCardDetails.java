package lindar.binlistnet.model;

import lombok.Data;

@Data
public class PaymentCardDetails {
    private CardNumber number;

    private String  scheme;
    private String  type;
    private String  brand;
    private boolean prepaid;

    private CardCountry country;

    private CardBank bank;
}
