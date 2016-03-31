package br.edu.ifpb.xml.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.edu.ifpb.bean.ex.Contato;
import br.edu.ifpb.bean.ex.Endereco;
import br.edu.ifpb.bean.ex.Telefone;

//servico funcionando - OK
public class LeitorXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato cont1 = new Contato(); 
		Contato cont2 = new Contato(); 
		Contato cont3 = new Contato();
		
		Endereco end1 = new Endereco(); 
		Endereco end2 = new Endereco(); 
		Endereco end3 = new Endereco();
		
		Telefone fone1 = new Telefone();
		Telefone fone2 = new Telefone();
		Telefone fone3 = new Telefone();
		
		Collection<Telefone> phones = new ArrayList<Telefone>();
		
		end1.setId(001);
		end1.setCidade("Sousa");
		end1.setBairro("Rachel Gadelha");
		end1.setComplemento("Loteamento");
		end1.setLogradouro("Lote1");
		end1.setNumero(79);
		end1.setCep("58803-160");
		
		end2.setId(002);
		end2.setCidade("Cajazeiras");
		end2.setBairro("Oasis");
		end2.setComplemento("Residencial");
		end2.setLogradouro("Quadra");
		end2.setNumero(101);
		end2.setCep("58800-500");
		
		end3.setId(003);
		end3.setCidade("Brejo");
		end3.setBairro("Moro");
		end3.setComplemento("Central");
		end3.setLogradouro("Sitio");
		end3.setNumero(1000);
		end3.setCep("58888-888");
		
		
		fone1.setId(001);
		fone1.setDdd(83);
		fone1.setNumero(91458009);
		
		fone2.setId(002);
		fone2.setDdd(83);
		fone2.setNumero(96540909);
		
		fone3.setId(003);
		fone3.setDdd(81);
		fone3.setNumero(91458009);

		phones.add(fone1);
		phones.add(fone2);
		phones.add(fone3);
		
		cont1.setId(001);
		cont1.setNome("One First");
		cont1.setEmail("onef@gmail.com");
		cont1.setEndereco(end1);
		cont1.setTelefones(phones);
		
		cont2.setId(002);
		cont2.setNome("Two Second");
		cont2.setEmail("twos@gmail.com");
		cont2.setEndereco(end2);
		cont2.setTelefones(phones);
		
		cont3.setId(003);
		cont3.setNome("Three Thirst");
		cont3.setEmail("threet@gmail.com");
		cont3.setEndereco(end3);
		cont3.setTelefones(phones);
		
		
		gerarXML001(cont1);
		gerarXML002(cont2);
		gerarXML003(cont3);
		
		//lerXML();
		lerXMLAnnotations();

	}
	
	//gera arquivo no diretorio
	public static void salvarArquivo(String doc, String file){
		File path = new File("D:\\Pessoal\\Francisco\\TCC\\"+file);
		
		
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.println(
			"<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>"
			);           
			writer.println(doc);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
	//metodo um - gera xml com nome dos pacotes
	public static void gerarXML001(Contato contact){
		XStream xstream = new XStream(new DomDriver());
		String strDoc = xstream.toXML(contact);
		salvarArquivo(strDoc, "gerarXML001.xml");
	}
	
	//metodo dois - gera xml sem nomes dos pacotes
	public static void gerarXML002(Contato contact){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Contato", Contato.class);
		xstream.aliasField("Endereco", Contato.class, "endereco");
		xstream.aliasField("Telefones", Contato.class, "telefones");
		xstream.alias("Telefones", Telefone.class);
		
		String strDoc = xstream.toXML(contact);
		salvarArquivo(strDoc, "gerarXML002.xml");
	}
	
	//leitor dos xml criados
	public static void lerXML(){
		FileReader reader = null;
		
		try {
			
			reader = new FileReader("D:\\Pessoal\\Francisco\\TCC\\gerarXML002.xml");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Contato", Contato.class);
		xstream.aliasField("Endereco", Contato.class, "endereco");
		xstream.aliasField("Telefones", Contato.class, "telefones");
		xstream.alias("Telefones", Telefone.class);
		
		Contato contato = (Contato) xstream.fromXML(reader);
		
		System.out.println(contato.toString());
		
	}
	
	//gerar xml com annotations
	public static void gerarXML003(Contato contact){
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		String docStr = xstream.toXML(contact);
		salvarArquivo(docStr, "gerarXML003.xml");		
	}
	
	
	public static void lerXMLAnnotations(){
		FileReader reader = null;
		try {
			
			reader = new FileReader("D:\\Pessoal\\Francisco\\TCC\\gerarXML003.xml");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(Contato.class);

		Contato contato = (Contato) xstream.fromXML(reader);
		System.out.println(contato.toString());
		
	}

}


