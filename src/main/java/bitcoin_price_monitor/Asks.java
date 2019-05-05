package bitcoin_price_monitor;

import java.util.ArrayList;

public class Asks {
	
    private final String recentId;
    
    public Asks(String recentId) {
    	this.recentId = recentId;
    }
	
	public String getRecentId() {
		return recentId;
	}
	
	public ArrayList<ArrayList<String>> getContent() {
		AsksBox ab = new AsksBox();
		return ab.getRecord(recentId);
	}
    
}
