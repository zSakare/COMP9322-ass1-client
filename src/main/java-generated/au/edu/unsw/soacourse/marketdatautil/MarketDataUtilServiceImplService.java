package au.edu.unsw.soacourse.marketdatautil;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-17T16:08:01.058+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "MarketDataUtilServiceImplService", 
                  wsdlLocation = "http://localhost:8080/COMP9322-ass1/MarketDataUtilService?wsdl",
                  targetNamespace = "http://marketdatautil.soacourse.unsw.edu.au/") 
public class MarketDataUtilServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://marketdatautil.soacourse.unsw.edu.au/", "MarketDataUtilServiceImplService");
    public final static QName MarketDataUtilServiceImplPort = new QName("http://marketdatautil.soacourse.unsw.edu.au/", "MarketDataUtilServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/COMP9322-ass1/MarketDataUtilService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MarketDataUtilServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/COMP9322-ass1/MarketDataUtilService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MarketDataUtilServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MarketDataUtilServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarketDataUtilServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns MarketDataUtilService
     */
    @WebEndpoint(name = "MarketDataUtilServiceImplPort")
    public MarketDataUtilService getMarketDataUtilServiceImplPort() {
        return super.getPort(MarketDataUtilServiceImplPort, MarketDataUtilService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MarketDataUtilService
     */
    @WebEndpoint(name = "MarketDataUtilServiceImplPort")
    public MarketDataUtilService getMarketDataUtilServiceImplPort(WebServiceFeature... features) {
        return super.getPort(MarketDataUtilServiceImplPort, MarketDataUtilService.class, features);
    }

}
