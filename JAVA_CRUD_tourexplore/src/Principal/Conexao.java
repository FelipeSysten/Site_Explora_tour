package Principal;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

 

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/exploretour";

	private static final String USUARIO = "root";

	private static final String SENHA = "infoplace";

 

	public static Connection conectar() throws SQLException {
		

		return DriverManager.getConnection(URL, USUARIO, SENHA);

	}

}
