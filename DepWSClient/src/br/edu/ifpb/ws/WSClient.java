package br.edu.ifpb.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.gov.camara.sitcamaraws.deputados.Deputados;
import br.gov.camara.sitcamaraws.deputados.DeputadosSoap;

public class WSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			URL url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx?wsdl"); //endpoint wsdl
			QName qname = new QName("http://www.camara.gov.br/SitCamaraWS/Deputados","Deputados"); //namespace e service
			Service service = Service.create(url, qname);
			DeputadosSoap depsoap = service.getPort(DeputadosSoap.class);
			while(depsoap.obterDeputados().getContent().iterator().hasNext()){
				System.out.println("Eh "+depsoap.obterDeputados());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
