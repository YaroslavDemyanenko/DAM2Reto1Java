package lecturaFicheros;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import modelo.objetos.Departamento;
import modelo.objetos.Empleado;

public class GenerarPDF {

	public void crearPDF(PdfWriter writer, Empleado[] empleados, Departamento[] departamentos) {
		
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		
		
		if (empleados != null) {
			
			document.add(new Paragraph("Tabla empleados"));
			
			Table tabla = new Table(8);
			
			tabla.addHeaderCell("DNI");
			tabla.addHeaderCell("Nombre");
			tabla.addHeaderCell("Apellidos");
			tabla.addHeaderCell("Sueldo");
			tabla.addHeaderCell("Superior");
			tabla.addHeaderCell("Fecha alta");
			tabla.addHeaderCell("Cargo");
			tabla.addHeaderCell("Departamento");
			
			for(int i=0; i < empleados.length; i++) {
				tabla.addCell(empleados[i].getDni());
				tabla.addCell(empleados[i].getNombre());
				tabla.addCell(empleados[i].getApellidos());
				tabla.addCell(Float.toString(empleados[i].getSueldo()));
				if(empleados[i].getEmpleJefe() !=null) {
					tabla.addCell(empleados[i].getEmpleJefe().getDni());
				}else {
					tabla.addCell("No tiene superior");
				}
				
				tabla.addCell(empleados[i].getFechaString());
				tabla.addCell(empleados[i].getCargo().getNombre());
				tabla.addCell(empleados[i].getDepartamento().getNombre());
			}
			document.add(tabla);
		}else if(departamentos != null) {
			
			document.add(new Paragraph("Tabla empleados"));
			
			Table tabla = new Table(3);
			
			tabla.addHeaderCell("ID");
			tabla.addHeaderCell("Nombre departamento");
			tabla.addHeaderCell("Centro");
			
			for(int i=0; i < departamentos.length; i++) {
				
				tabla.addCell(Integer.toString(departamentos[i].getId()));
				tabla.addCell(departamentos[i].getNombre());
				tabla.addCell(departamentos[i].getCentro().getNombre());
			}
			document.add(tabla);
		}
		
		document.close();
		
	}
}