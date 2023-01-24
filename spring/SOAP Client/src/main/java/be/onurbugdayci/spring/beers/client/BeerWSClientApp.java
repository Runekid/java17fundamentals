package be.onurbugdayci.spring.beers.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class BeerWSClientApp {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(BeerWSClientApp.class,args);
		BeerServiceEndpoint beerService = ctx.getBean("beerService", BeerServiceEndpoint.class);
		Beer beer = beerService.getBeerById(22);
		System.out.println(beer.getName());
      System.out.println(beer.getBrewer().getName());
      System.out.println(beer.getCategory().getName());
		int orderNumber = beerService.orderBeer("Homer",22, 1);
      System.out.println("Order number :" + orderNumber);
	}

	@Bean
	public JaxWsPortProxyFactoryBean beerService()
	   throws MalformedURLException {
		JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
		proxy.setServiceInterface(BeerServiceEndpoint.class);
		proxy.setWsdlDocumentUrl(new URL(
		   "http://localhost/BeerService?wsdl"));
		proxy.setNamespaceUri(
		   "http://web.beers.spring.noelvaes.eu/");
		proxy.setServiceName("BeerService");
		proxy.setPortName("BeerServiceEndpointPort");
		return proxy;
	}
}
