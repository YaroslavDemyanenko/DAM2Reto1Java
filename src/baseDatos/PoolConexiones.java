package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import logs.Logger;

public class PoolConexiones {
	//BasicDataSource basicDataSource = new BasicDataSource();
	DataSource dataSource;
	
	public DataSource CrearConexiones() {	
		Properties propiedades = new Properties();
		
		try {
			propiedades.load(new FileInputStream("datasource_config.properties"));
		} catch (FileNotFoundException e) {
			Logger.logger.escribirArchivo("Error al crear la conexión a la base de datos");
			return null;
		} catch (IOException e) {
			Logger.logger.escribirArchivo("Error al crear la conexión a la base de datos");
			return null;
		}
	
		try {
			dataSource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (Exception e) {
			Logger.logger.escribirArchivo("Error al crear la conexión a la base de datos");
			return null;
		}
		return dataSource;
	}
	
}
