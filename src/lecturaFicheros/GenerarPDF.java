package lecturaFicheros;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

public class GenerarPDF {

	public void crearPDF(PdfWriter writer, Empleado[] empleados, Departamento[] departamentos) {
		
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		if (empleados != null) {
			for(int i=0; i < empleados.length; i++) {
				document.add(new Paragraph( empleados[i].getNombre()));
			}
			/**
			//Creating a PdfDocument object 
		      PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file));     

		      //Creating a Document object 
		      Document doc = new Document(pdfDoc);        

		      //Creating a table 
		      Table table = new Table(2);     

		      //Adding cells to the table 
		      table.addCell(new Cell().add("Name")); 
		      table.addCell(new Cell().add("Raju")); 
		      table.addCell(new Cell().add("Id")); 
		      table.addCell(new Cell().add("1001")); 
		      table.addCell(new Cell().add("Designation")); 
		      table.addCell(new Cell().add("Programmer")); 
			**/
			
			
		}else if(departamentos != null) {
			
			Table tabla = new Table(3);
			
			tabla.addHeaderCell("ID");
			tabla.addHeaderCell("Nombre dpto.");
			tabla.addHeaderCell("Centro");
			
			for(int i=0; i < departamentos.length; i++) {
				//document.add(new Paragraph(departamentos[i].getId() + " " + departamentos[i].getNombre() + " " + departamentos[i].getCentro()));
				
				tabla.addCell(Integer.toString(departamentos[i].getId()));
				tabla.addCell(departamentos[i].getNombre());
				tabla.addCell(departamentos[i].getCentro().getNombre());
			}
			document.add(tabla);
		}
		
		document.close();
		
	}
}