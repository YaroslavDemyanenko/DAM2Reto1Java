package lecturaFicheros;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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
		}else if(departamentos != null) {
			
			//PdfPTable table = new PdfPTable(3);                
            
            //table.addCell("Celda 1");
			
			for(int i=0; i < departamentos.length; i++) {
				document.add(new Paragraph(departamentos[i].getId() + " " + departamentos[i].getNombre() + " " + departamentos[i].getCentro()));
			}
		}
		
		document.close();
		
	}
}