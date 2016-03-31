package br.edu.ifpb.ws.dep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.gov.camara.sitcamaraws.deputados.Deputados;
import br.gov.camara.sitcamaraws.deputados.DeputadosSoap;

//cliente funcionando - OK
public class WSClientSoap {

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
