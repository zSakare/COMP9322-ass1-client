package au.edu.unsw.soacourse.topdown;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.edu.unsw.soacourse.marketdatautil.MarketDataUtilService;
import au.edu.unsw.soacourse.marketdatautil.SummariseMarketDataRequest;
import au.edu.unsw.soacourse.marketdatautil.SummariseMarketDataResponse;
import au.edu.unsw.soacourse.marketdatautil.VisualiseMarketDataRequest;
import au.edu.unsw.soacourse.marketdatautil.VisualiseMarketDataResponse;

@Controller
public class TopDownSimpleServiceController {
	@Autowired
	private TopDownSimpleService simple; //this is instantiated by jaxws:client id=simple in dispatcher-servlet.xml
	@Autowired
	private MarketDataUtilService market;
	private List<String> idList = new ArrayList<String>();
	
	@RequestMapping(value="/topdownServiceClient", method=RequestMethod.GET)
	public String loadPage(ModelMap model) throws Exception {
		model.addAttribute("marketData", new MarketData());
		model.addAttribute("fileData", new FileData());
		model.addAttribute("idList", idList);
		return "topdownServicePage";
	}
	
	@RequestMapping(value="/importMarketData", method=RequestMethod.POST)
	public String requestMarketData(@ModelAttribute MarketData marketData, ModelMap model) throws Exception {
		// Set up an Import market data request.
		ImportMarketDataRequest request = new ObjectFactory().createImportMarketDataRequest();
		request.setSec(marketData.getSec());
		request.setStartDate(marketData.getStartDate());	  
		request.setEndDate(marketData.getEndDate());
		         
		// Call the service with the request
		ImportMarketDataResponse response = simple.importMarketData(request);
		
		// Add response to the jsp
		model.addAttribute("returnImportMarketData", response.getEventSetId());
		
		idList.add(response.getEventSetId());
		
		model.addAttribute("idList", idList);
		
		return "topdownServicePage";
	}
	
	@RequestMapping(value="/downloadFile", method=RequestMethod.POST)
	public String requestDownloadFile(@ModelAttribute FileData fileData, ModelMap model) throws Exception {
		// Set up a download request
		DownloadFileRequest request = new ObjectFactory().createDownloadFileRequest();
		request.setEventSetId(fileData.getEventSetId());
		
		// Call the service with the request
		DownloadFileResponse response = simple.downloadFile(request);
		
		// Add response to the jsp
		model.addAttribute("returnDownloadFileData", response.getDataURL());
		model.addAttribute("idList", idList);
		
		return "topdownServicePage";
	}
	
	@RequestMapping(value="/summarise", method=RequestMethod.POST)
	public String requestSummariseFile(@ModelAttribute FileData fileData, ModelMap model) throws Exception {
		// Set up a summarise request
		SummariseMarketDataRequest request = new au.edu.unsw.soacourse.marketdatautil.ObjectFactory().createSummariseMarketDataRequest();
		request.setEventSetId(fileData.getEventSetId());
		
		// Call the service with the request
		SummariseMarketDataResponse response = market.summariseMarketData(request);
		
		// Add response to the jsp
		model.addAttribute("returnSummariseFileData", response);
		model.addAttribute("idList", idList);
		
		return "topdownServicePage";
	}
	
	@RequestMapping(value="/visualise", method=RequestMethod.POST)
	public String requestVisualiseFile(@ModelAttribute FileData fileData, ModelMap model) throws Exception {
		// Set up a visualise request
		VisualiseMarketDataRequest request = new au.edu.unsw.soacourse.marketdatautil.ObjectFactory().createVisualiseMarketDataRequest();
		request.setEventSetId(fileData.getEventSetId());
		
		// Call the service with the request
		VisualiseMarketDataResponse response = market.visualiseMarketData(request);
		
		// Add response to the jsp
		model.addAttribute("returnVisualiseFileData", response.getDataURL());
		model.addAttribute("idList", idList);
		
		return "topdownServicePage";
	}
}
