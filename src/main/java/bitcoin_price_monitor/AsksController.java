package bitcoin_price_monitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsksController {

	@RequestMapping(value = "/asks", method = RequestMethod.GET)
	public Asks Asks(@RequestParam(value = "recentId", defaultValue = "all") String recentId) {
		return new Asks(recentId);
	}
}
