package lecturaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import modelo.Departamento;

public class LectorXml {

	private Departamento departamentos = new Departamento();
	
	//public static void main(String args[]) {
		//Departamento departamentos = new Departamento();
	public Departamento leerXml(String path) {
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
					//for(int i = 0; i < ch.length;i++) {
						if (bDepartamento) {
							departamentos.setId(id);
						    departamentos.setNombre(new String(ch, start, length));
						    System.out.println(departamentos);
						    bDepartamento = false;
						}
					//}
					
				}
                
			};

			//File file = new File("C:\\workspace_reto1\\DAM2Reto1Java\\ficheros\\departamentos.xml");
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
		//return;
    }
	
}
