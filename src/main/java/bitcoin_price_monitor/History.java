package bitcoin_price_monitor;

import java.util.ArrayList;

public class History {
	
    private final String topId;
    
    public History(String topId) {
    	this.topId = topId;
    }
	
	public String getTopId() {
		return topId;
	}
	
	public ArrayList<String> getContent() {
		HistoryBox hb = new HistoryBox();
		return hb.getPrice(topId);
	}
    
}
