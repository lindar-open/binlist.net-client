package lindar.binlistnet.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;
import lindar.acolyte.vo.Pair;
import lindar.binlistnet.model.PaymentCardDetails;

import java.util.Optional;

public class BinLookupResource {
    private static final String BIN_LIST_NET_URL = "https://lookup.binlist.net/{bin}";

    private Gson gson = new GsonBuilder().create();

    public Optional<PaymentCardDetails> lookupBinListNet(String binNumber) {
        String url = UrlAcolyte.replacePathParamsByName(BIN_LIST_NET_URL, Pair.of("bin", binNumber));

        WellRestedRequest request = WellRestedRequest.builder()
                                                     .url(url)
                                                     .disableCookiesForAuthRequests()
                                                     .build();
        WellRestedResponse response = request.get().submit();

        try {
            return Optional.of(gson.fromJson(response.getServerResponse(), PaymentCardDetails.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

}
