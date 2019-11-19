package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import launcher.Launcher;
import logs.Logger;

public class PoolConexiones {
	
	DataSource dataSource;
	private Logger log = Logger.getInstance();
	
	public DataSource CrearConexiones() {	
		Properties propiedades = new Properties();
		
		try {
			propiedades.load(new FileInputStream("datasource_config.properties"));
		} catch (FileNotFoundException e) {
			log.loggear("Error al crear la conexión a la base de datos",Launcher.class, 3);
			return null;
		} catch (IOException e) {
			log.loggear("Error al crear la conexión a la base de datos",Launcher.class, 3);
			return null;
		}
	
		try {
			dataSource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (Exception e) {
			log.loggear("Error al crear la conexión a la base de datos",Launcher.class, 3);
			return null;
		}
		return dataSource;
	}
	
}
