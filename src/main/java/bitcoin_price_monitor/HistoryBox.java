package bitcoin_price_monitor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HistoryBox {

	public ArrayList<String> getPrice(String topId) {

		JSONParser parser = new JSONParser();
		PriorityQueue<String> reversed = new PriorityQueue<String>(Comparator.reverseOrder());

		try {
			URL bitstamp = new URL("https://www.bitstamp.net/api/v2/transactions/btcusd/"); 
			URLConnection yc = bitstamp.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				JSONArray a = (JSONArray) parser.parse(inputLine);

				for (Object o : a) {
					JSONObject tutorials = (JSONObject) o;
					String price = (String) tutorials.get("price");
					reversed.add(price);
				}
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (topId.equals("all")) {
			topId = "100";
		}
		
		int num = Integer.parseInt(topId);
		ArrayList<String> ret = new ArrayList<String>();
		
		for (int i = 0; i < num; i++) {
			ret.add(reversed.poll());
		}
		
		return ret;
	}
}
