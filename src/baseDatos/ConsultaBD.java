package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import launcher.Launcher;
import logs.Logger;

public class ConsultaBD {

	private PoolConexiones pool;
	private DataSource datasource;
	private Connection con;
	private Logger log = Logger.getInstance();

	public ConsultaBD() {
		pool = new PoolConexiones();
		datasource = pool.CrearConexiones();
		con = null;
	}

	public String consultarToGson(String consulta) {
		String resultado = "[";
		
		try {
			con = datasource.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			int numColumnas = rs.getMetaData().getColumnCount();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					resultado += "{\"";
					for (int i = 1; i <= numColumnas; i++) {
						if (i != 1)
							resultado += ",\"";
						if (rs.getMetaData().getColumnTypeName(i).equals("VARCHAR")) {
							resultado += rs.getMetaData().getColumnLabel(i) + "\":\"";
							resultado += rs.getString(i) + "\"";
						}
						else if(rs.getMetaData().getColumnTypeName(i).equals("DATETIME") || rs.getMetaData().getColumnTypeName(i).equals("date")){
							resultado += rs.getMetaData().getColumnLabel(i) + "\":\"";
							resultado += rs.getString(i) + "\"";
						}
						else {
							resultado += rs.getMetaData().getColumnLabel(i) + "\":";
							resultado += rs.getString(i);
						}
						if (i == numColumnas)
							resultado += "},";
					}
				}
				return resultado.substring(0, resultado.length() - 1) + "]";
			} else {
				return "";
			}

		} catch (SQLException e) {
			log.loggear("Error en la consulta a la base de datos",Launcher.class, 3);
			return null;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				log.loggear("Error en la consulta a la base de datos",Launcher.class, 3);
				return null;
			}
		}
	}

	/**
	 * Insert generico a la base de datos
	 * 
	 * @param objetos     array de Object, si se quiere meter un objeto se debe
	 *                    transformar en un array de Object, no pueden meterse
	 *                    matrizes, utilizar un for para eso
	 * @param nombreTabla nombre de la tabla a la cual se desea realizar un insert
	 * 
	 * @return booleano que indica si se han guardado bien los registros
	 */
	public boolean insertGenerico(Object[] objetos, String nombreTabla) {
		try {
			con = datasource.getConnection();
			@SuppressWarnings("rawtypes")
			Class[] clasesObj = arrayClases(objetos);
			String query = prepararQuery(objetos.length, nombreTabla);
			PreparedStatement statementGenerico = generarStatement(objetos, clasesObj, query);
			if (statementGenerico != null) {
				statementGenerico.execute();
			}
			return true;
		} catch (SQLException e1) {
			log.loggear("Error al insertar datos en la base de datos",Launcher.class, 2);
			return false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				log.loggear("Error al insertar datos en la base de datos",Launcher.class, 2);
			}
		}
	}

	/**
	 * Prepara el statement para su insercion a la base de datos organizando cada
	 * objeto de la forma que le corresponde
	 * 
	 * @param objetos array de Object
	 * @param clases  array de clases, debe ser paralelo a objetos
	 * @param query   query que se quiere ejecutar
	 * @return Prepared statement listo para ejecutar
	 */
	public PreparedStatement generarStatement(Object[] objetos, @SuppressWarnings("rawtypes") Class[] clases, String query) {
		try {
			PreparedStatement statementGenerico = this.con.prepareStatement(query);
			for (int i = 0; i < objetos.length; i++) {
				if (clases[i] == String.class) {
					statementGenerico.setString(i + 1, (String) objetos[i]);
				} else if (clases[i] == Float.class) {
					statementGenerico.setFloat(i + 1, (Float) objetos[i]);
				} else if (clases[i] == Double.class) {
					statementGenerico.setDouble(i + 1, (Double) objetos[i]);				
				} else if (clases[i] == Integer.class) {
					statementGenerico.setInt(i + 1, (int) objetos[i]);
				} else if (clases[i] == java.util.Date.class) {
					statementGenerico.setTimestamp(i + 1, new java.sql.Timestamp(((java.util.Date) objetos[i]).getTime()));
				} else if (clases[i] == Boolean.class) {
					if((boolean)objetos[i] == true) {
						statementGenerico.setInt(i + 1, 1);
					}else {
						statementGenerico.setInt(i + 1, 0);
					}
				} else {
					statementGenerico.setString(i + 1, (String) objetos[i]);
				}
			}
			return statementGenerico;
		} catch (SQLException e) {
			log.loggear("Error al generar la sentencia",Launcher.class, 3);
			return null;
		}
	}

	/**
	 * Crea un array de clases paralelo al array que se le pasa
	 * 
	 * @param objetos array de objetos al que se le va a hacer una array de clases paralelo
	 * @return array de clases
	 */
	@SuppressWarnings("rawtypes")
	public Class[] arrayClases(Object[] objetos) {
		Class[] clasesObj = new Class[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			clasesObj[i] = objetos[i].getClass();
		}
		return clasesObj;
	}

	/**
	 * Prepara el query
	 * 
	 * @param num numero de values a insertar
	 * @param tabla nombre de la tabla
	 * @return cadena con la query
	 */
	public String prepararQuery(int num, String tabla) {
		String query = "insert into " + tabla + " values(";
		for (int i = 0; i < num; i++) {
			query += "?,";
		}
		query = (query.substring(0, query.length() - 1)) + ");";
		return query;
	}
	
	/**
	 * Delete generico para borrar consultas simples, pasar condiciones separadas metidas en un array
	 * @param tabla de la cual se quiere borrar fila
	 * @param condiciones array de string con condiciones ej: "'dni' = '12345678R'"
	 * @return true en caso de haber borrado satisfactoriamente, false en caso de sql exception
	 */
	public boolean deleteGenerico(String tabla, String[] condiciones) {
		try {
			con = datasource.getConnection();
			String statement = "DELETE FROM " + tabla + " WHERE ";
			for (String condi : condiciones) {
				statement += condi + " AND ";
			}
			statement = statement.substring(0, statement.length() - 5);
			PreparedStatement statementGenerico = this.con.prepareStatement(statement);
			return statementGenerico.execute();
		} catch (SQLException e1) {
			log.loggear("Error al borrar un elemento de la base de datos",Launcher.class, 2);
			return false;
		}
	}
}
