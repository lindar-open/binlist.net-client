package lindar.binlistnet.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;
import lindar.acolyte.vo.Pair;
import lindar.binlistnet.model.BinListNetCardDetails;

import java.util.Optional;

class BinListNetLookupResource {
    private static final String BIN_LIST_NET_URL = "https://lookup.binlist.net/{bin}";

    private Gson gson = new GsonBuilder().create();

    Optional<BinListNetCardDetails> lookupBinNumber(String binNumber) {
        String url = UrlAcolyte.replacePathParamsByName(BIN_LIST_NET_URL, Pair.of("bin", binNumber));

        WellRestedRequest request = WellRestedRequest.builder()
                                                     .url(url)
                                                     .disableCookiesForAuthRequests()
                                                     .build();
        WellRestedResponse response = request.get().submit();

        try {
            return Optional.of(gson.fromJson(response.getServerResponse(), BinListNetCardDetails.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

}
