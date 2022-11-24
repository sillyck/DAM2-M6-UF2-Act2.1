import java.sql.*;

public class main {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/discografica?useSSL=false", "root", "123");
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM albums;");

			while (resul.next()) {
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3) + " "
						+ resul.getString(4));
			}

			resul.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
