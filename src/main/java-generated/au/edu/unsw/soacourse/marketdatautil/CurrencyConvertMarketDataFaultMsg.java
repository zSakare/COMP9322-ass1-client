
package au.edu.unsw.soacourse.marketdatautil;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-17T16:08:01.047+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "currencyConvertMarketDataFault", targetNamespace = "http://marketdatautil.soacourse.unsw.edu.au")
public class CurrencyConvertMarketDataFaultMsg extends Exception {
    
    private au.edu.unsw.soacourse.marketdatautil.ServiceFaultType currencyConvertMarketDataFault;

    public CurrencyConvertMarketDataFaultMsg() {
        super();
    }
    
    public CurrencyConvertMarketDataFaultMsg(String message) {
        super(message);
    }
    
    public CurrencyConvertMarketDataFaultMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyConvertMarketDataFaultMsg(String message, au.edu.unsw.soacourse.marketdatautil.ServiceFaultType currencyConvertMarketDataFault) {
        super(message);
        this.currencyConvertMarketDataFault = currencyConvertMarketDataFault;
    }

    public CurrencyConvertMarketDataFaultMsg(String message, au.edu.unsw.soacourse.marketdatautil.ServiceFaultType currencyConvertMarketDataFault, Throwable cause) {
        super(message, cause);
        this.currencyConvertMarketDataFault = currencyConvertMarketDataFault;
    }

    public au.edu.unsw.soacourse.marketdatautil.ServiceFaultType getFaultInfo() {
        return this.currencyConvertMarketDataFault;
    }
}
