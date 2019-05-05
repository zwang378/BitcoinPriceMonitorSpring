package bitcoin_price_monitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public History History(@RequestParam(value = "topId", defaultValue = "all") String topId) {
		return new History(topId);
	}
}
