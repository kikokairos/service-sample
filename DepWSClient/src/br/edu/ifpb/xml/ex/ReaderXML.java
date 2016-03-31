package br.edu.ifpb.xml.ex;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.edu.ifpb.bean.ex.Telefone;
import br.gov.camara.sitcamaraws.deputados.Deputados;

public class ReaderXML {
	
	/*public List<Telefone> carrega(InputStream is){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Deputados", Deputados.class);
		return (List<Telefone>) xstream.fromXML(is);	
	}*/
	
	public List<Deputados> carrega(InputStream is){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Deputados", Deputados.class);
		return (List<Deputados>) xstream.fromXML(is);	
	}

}
