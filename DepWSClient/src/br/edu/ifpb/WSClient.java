package br.edu.ifpb;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.gov.camara.sitcamaraws.deputados.DeputadosSoap;

public class WSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			URL url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx?wsdl");
			QName qname = new QName("http://www.camara.gov.br/SitCamaraWS/Deputados","Deputados");
			Service service = Service.create(url, qname);
			DeputadosSoap depsoap = service.getPort(DeputadosSoap.class);
			System.out.println("Eh "+depsoap.obterDeputados());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
