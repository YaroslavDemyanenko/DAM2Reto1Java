package lecturaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorXml {

	public static void main(String args[]) {
	//public void leerXml(String path) {
		try {
    		
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bDepartamento = false;
                int id = 0;
                String departamento = null;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                	
            		if (qName.equalsIgnoreCase("departamento")) {
            			id = Integer.parseInt(attributes.getValue("id"));
            			bDepartamento = true;
            		}
					
				}
					
				public void characters(char ch[], int start, int length) throws SAXException {
					    
					    if (bDepartamento) {
					    	departamento = new String(ch, start, length);
					    	System.out.println(id + " " + departamento);
					    	bDepartamento = false;
					    }
					    
				    }
					
			};

				File file = new File("C:\\workspace_reto1\\DAM2Reto1Java\\ficheros\\departamentos.xml");
				InputStream inputStream = new FileInputStream(file);
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				
				InputSource is = new InputSource(reader);
				is.setEncoding("UTF-8");
	            saxParser.parse(is, handler);
	
		        } 
    	catch (Exception e) {
    		e.printStackTrace();
		}
		
		return;
    }
	
}
