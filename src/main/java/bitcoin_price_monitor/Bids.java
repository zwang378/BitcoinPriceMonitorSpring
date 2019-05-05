package bitcoin_price_monitor;

import java.util.ArrayList;

public class Bids {
	
    private final String recentId;
    
    public Bids(String recentId) {
    	this.recentId = recentId;
    }
	
	public String getRecentId() {
		return recentId;
	}
	
	public ArrayList<ArrayList<String>> getContent() {
		BidsBox bb = new BidsBox();
		return bb.getRecord(recentId);
	}
    
}
