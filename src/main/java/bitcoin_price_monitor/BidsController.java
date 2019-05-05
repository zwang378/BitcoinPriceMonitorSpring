package bitcoin_price_monitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidsController {

	@RequestMapping(value = "/bids", method = RequestMethod.GET)
	public Bids Bids(@RequestParam(value = "recentId", defaultValue = "all") String recentId) {
		return new Bids(recentId);
	}
}
