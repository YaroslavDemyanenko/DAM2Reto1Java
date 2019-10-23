package lecturaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import modelo.objetos.Departamento;


import baseDatos.ConsultaBD;
import modelo.Modelo;


public class LectorXml {

	private List<Departamento> departamentos;
	private ConsultaBD bd;
	private Modelo mod;
	
	public LectorXml(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
		departamentos = new ArrayList();
	}
	
	public List<Departamento> leerXml(String path) {
		try {
    		
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() 
            {
                boolean bDepartamento = false;
                int id = 0;
                
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
                {
            		if (qName.equalsIgnoreCase("departamento")) {
            			id = Integer.parseInt(attributes.getValue("id"));
            			bDepartamento = true;
            		}
				}
				public void characters(char ch[], int start, int length) throws SAXException 
				{
						if (bDepartamento) {
							Departamento depar = new Departamento(id,new String(ch, start, length),null);
							departamentos.add(depar);
						    bDepartamento = false;
						}
					
				}
                
			};

			File file = new File(path);
				InputStream inputStream = new FileInputStream(file);
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				
				InputSource is = new InputSource(reader);
				is.setEncoding("UTF-8");
	            saxParser.parse(is, handler);
	
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (Exception e) {
			System.out.println("Algo ha fallado a la hora de leer tu archivo");
		}
		return departamentos;
    }
	
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
