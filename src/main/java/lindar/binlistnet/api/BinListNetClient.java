package lindar.binlistnet.api;

import lindar.binlistnet.model.BinListNetCardDetails;

import java.util.Optional;

public class BinListNetClient {

    private BinListNetLookupResource lookupResource;

    public BinListNetClient() {
        BinListNetLookupResource lookupResource = new BinListNetLookupResource();
        this.lookupResource = lookupResource;
    }

    public Optional<BinListNetCardDetails> lookupBinNumberNet(String binNumber) {
        return lookupResource.lookupBinNumber(binNumber);
    }

}
