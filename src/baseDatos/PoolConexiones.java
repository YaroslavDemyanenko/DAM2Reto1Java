package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import logs.Logger;

public class PoolConexiones {
	
	DataSource dataSource;
	private Logger log = Logger.getInstance();
	
	public DataSource CrearConexiones() {	
		Properties propiedades = new Properties();
		
		try {
			propiedades.load(new FileInputStream("datasource_config.properties"));
			//JOptionPane.showMessageDialog(null, "Archivo cargado correctamente", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Archivo de configuracion no encontrado", null, JOptionPane.ERROR_MESSAGE);
			log.loggear("Archivo de configuracion de la base de datos no encontrado",this.getClass(), 5);
			return null;
		} catch (IOException e) {
			log.loggear("Error al leer el archivo con la configuracion a la base de datos",this.getClass(), 5);
			return null;
		}
	
		try {
			dataSource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (Exception e) {
			log.loggear("Error al crear la conexión a la base de datos",this.getClass(), 3);
			return null;
		}
		return dataSource;
	}
	
}
