package au.edu.unsw.soacourse.topdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketServiceController {

	// TODO: Add the TopDownSimpleService interface as a member of the controller
	@Autowired
	private TopDownSimpleService simple; //this is instantiated by jaxws:client id=simple in dispatcher-servlet.xml
	
	@RequestMapping("/importMarket")
	public String processImportMarketData(ModelMap model) throws Exception {
		// TODO: Add the creation of an impoartMarketData request type and populate it
		ImportMarketDataRequest request = new ObjectFactory().createImportMarketDataRequest();
		request.setSec("ABC");
		request.setStartDate("01-12-2014");	  
		request.setEndDate("01-12-2014");	
		request.setDataSource("http://www.example.org.ss/marketfile");
		   
		// TODO: Call the web service      
		ImportMarketDataResponse response = simple.importMarketData(request);
		
		// TODO: Replace null with the results from the web service response.
//		model.addAttribute("returnData", response.getReturn());

		// View we are returning to, in this case processImportMarketData.jsp 
		return "processImportMarketData";
	}

   @RequestMapping("/downloadFile")
   public String processDownloadFile(ModelMap model) throws Exception {
      // TODO: Add the creation of a DownloadFile request type and populate it
	  DownloadFileRequest request = new ObjectFactory().createDownloadFileRequest();
//	  request.setEventSetID("abc-abc-111");

      // TODO: Call the web service 
	  DownloadFileResponse response = simple.downloadFile(request);
      
      // TODO: Replace null with the results from the web service response.
//      model.addAttribute("returnData", response.getReturn());
      
      // View we are returning to, in this case processImportMarketData.jsp 
      return "processDownloadFile";
   }

}