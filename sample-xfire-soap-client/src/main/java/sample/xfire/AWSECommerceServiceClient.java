
package sample.xfire;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;
import org.codehaus.xfire.xmlbeans.XmlBeansTypeRegistry;

public class AWSECommerceServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public AWSECommerceServiceClient() {
        create0();
        Endpoint AWSECommerceServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePortTypeLocalEndpoint"), new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePortTypeLocalBinding"), "xfire.local://AWSECommerceService");
        endpoints.put(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePortTypeLocalEndpoint"), AWSECommerceServicePortTypeLocalEndpointEP);
        Endpoint AWSECommerceServicePortEP = service0 .addEndpoint(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePort"), new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServiceBinding"), "http://soap.amazon.co.jp/onca/soap?Service=AWSECommerceService");
        endpoints.put(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePort"), AWSECommerceServicePortEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        props.put("objectServiceFactory.style", "document");
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new XmlBeansTypeRegistry()));
        asf.setBindingCreationEnabled(true);
        service0 = asf.create((sample.xfire.AWSECommerceServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServiceBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public AWSECommerceServicePortType getAWSECommerceServicePortTypeLocalEndpoint() {
        return ((AWSECommerceServicePortType)(this).getEndpoint(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePortTypeLocalEndpoint")));
    }

    public AWSECommerceServicePortType getAWSECommerceServicePortTypeLocalEndpoint(String url) {
        AWSECommerceServicePortType var = getAWSECommerceServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public AWSECommerceServicePortType getAWSECommerceServicePort() {
        return ((AWSECommerceServicePortType)(this).getEndpoint(new QName("http://webservices.amazon.com/AWSECommerceService/2006-06-28", "AWSECommerceServicePort")));
    }

    public AWSECommerceServicePortType getAWSECommerceServicePort(String url) {
        AWSECommerceServicePortType var = getAWSECommerceServicePort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

}
