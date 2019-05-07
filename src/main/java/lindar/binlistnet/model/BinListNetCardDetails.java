package lindar.binlistnet.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BinListNetCardDetails {
    private CardNumber number;

    @SerializedName("scheme")
    private String  paymentSystem;
    @SerializedName("type")
    private String  cardType;
    @SerializedName("brand")
    private String  cardLevel;
    private boolean prepaid;

    private CardCountry country;

    private CardBank bank;
}
