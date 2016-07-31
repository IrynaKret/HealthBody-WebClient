
package edu.softserveinc.healthbody.webclient.api;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@Component
@ComponentScan
@WebServiceClient(name = "HealthBodyServiceImplService", targetNamespace = "http://webservice.healthbody.softserveinc.edu/", wsdlLocation = "http://localhost:8080/HealthBody-WebService/HealthBodyService?wsdl")
public class HealthBodyServiceImplService
    extends Service
{

    private final static URL HEALTHBODYSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException HEALTHBODYSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName HEALTHBODYSERVICEIMPLSERVICE_QNAME = new QName("http://webservice.healthbody.softserveinc.edu/", "HealthBodyServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/HealthBody-WebService/HealthBodyService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HEALTHBODYSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        HEALTHBODYSERVICEIMPLSERVICE_EXCEPTION = e;
    }
  
    public HealthBodyServiceImplService() {
        super(__getWsdlLocation(), HEALTHBODYSERVICEIMPLSERVICE_QNAME);
    }

    public HealthBodyServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HEALTHBODYSERVICEIMPLSERVICE_QNAME, features);
    }

    public HealthBodyServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, HEALTHBODYSERVICEIMPLSERVICE_QNAME);
    }

    public HealthBodyServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HEALTHBODYSERVICEIMPLSERVICE_QNAME, features);
    }

    public HealthBodyServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HealthBodyServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HealthBodyService
     */
    @Bean
    @WebEndpoint(name = "HealthBodyServiceImplPort")
    public HealthBodyService getHealthBodyServiceImplPort() {
        return super.getPort(new QName("http://webservice.healthbody.softserveinc.edu/", "HealthBodyServiceImplPort"), HealthBodyService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HealthBodyService
     */
    @Bean
    @WebEndpoint(name = "HealthBodyServiceImplPort")
    public HealthBodyService getHealthBodyServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.healthbody.softserveinc.edu/", "HealthBodyServiceImplPort"), HealthBodyService.class, features);
    }
    @Bean
    private static URL __getWsdlLocation() {
        if (HEALTHBODYSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw HEALTHBODYSERVICEIMPLSERVICE_EXCEPTION;
        }
        return HEALTHBODYSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
