package au.edu.unsw.soacourse.topdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopDownSimpleServiceController {
	@Autowired
	private TopDownSimpleService simple; //this is instantiated by jaxws:client id=simple in dispatcher-servlet.xml
	
	@RequestMapping(value="/topdownServiceClient", method=RequestMethod.GET)
	public String loadPage(ModelMap model) throws Exception {
		model.addAttribute("marketData", new MarketData());
		model.addAttribute("fileData", new FileData());
		return "topdownServicePage";
	}
	
	@RequestMapping(value="/topdownServiceClient", method=RequestMethod.POST)
	public String requestMarketData(@ModelAttribute MarketData marketData, @ModelAttribute FileData fileData, ModelMap model) throws Exception {
		if (marketData.getId().equals("marketData")) {
			ImportMarketDataRequest request = new ObjectFactory().createImportMarketDataRequest();
			request.setSec(marketData.getSec());
			request.setStartDate(marketData.getStartDate());	  
			request.setEndDate(marketData.getEndDate());
			         
			ImportMarketDataResponse response = simple.importMarketData(request);
			marketData.setId("");
			
			model.addAttribute("returnData", response.getReturn());
		}
		
		if (fileData.getId().equals("fileData")) {
			DownloadFileRequest request = new ObjectFactory().createDownloadFileRequest();
			request.setEventSetID(fileData.getEventSetId());
			
			DownloadFileResponse response = simple.downloadFile(request);
			fileData.setId("");
			model.addAttribute("returnData", response.getReturn());
		}
		
		return "topdownServicePage";
	}
}
