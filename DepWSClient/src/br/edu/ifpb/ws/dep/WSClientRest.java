package br.edu.ifpb.ws.dep;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.gov.camara.sitcamaraws.deputados.Deputados;

public class WSClientRest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		URL url;
		try {
			url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx/ObterDeputados");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader bfreader = new BufferedReader(reader);
			
			//concatena string recebida do ws
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while ((line = bfreader.readLine()) != null) {
				stringBuilder.append(line);				
			}
			bfreader.close();
			conn.disconnect();
			
			//montar xml jdom
			/*SAXBuilder sbuilder = new SAXBuilder();
			Document doc = sbuilder.build(stringBuilder.toString());
			*/			
			
			System.out.println("Eh "+stringBuilder.toString());
				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
