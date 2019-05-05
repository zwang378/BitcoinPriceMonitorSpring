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

public class AsksBox {

	public ArrayList<ArrayList<String>> getRecord(String recentId) {

		JSONParser parser = new JSONParser();
		ArrayList<ArrayList<String>> ret = new ArrayList<>();

		try {
			URL bitstamp = new URL("https://www.bitstamp.net/api/v2/order_book/btcusd/");
			URLConnection yc = bitstamp.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				JSONObject jo = (JSONObject) parser.parse(inputLine);
				JSONArray asks = (JSONArray) jo.get("asks");

				if (recentId.equals("all")) {
					recentId = "100";
				}

				int num = Integer.valueOf(recentId);

				for (int i = 0; i < num; i++) {
					JSONArray item = (JSONArray) asks.get(i);
					String price = (String) item.get(0);
					String amount = (String) item.get(1);
					ArrayList<String> temp = new ArrayList<>();
					temp.add(price);
					temp.add(amount);
					ret.add(temp);
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

		return ret;
	}
}
