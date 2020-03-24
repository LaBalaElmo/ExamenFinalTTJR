package spotify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import spotify.Conector;

public class Conector {
	/**
	 * Atributos de clase
	 */
	private static Connection con;
	private static Conector INSTANCE = null;

	/**
	 * Consructor
	 */
	private Conector() {

	}

	/**
	 * Crear instancia
	 */

	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	/**
	 * Obtener instancia
	 */

	public static Conector getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	/**
	 * Crear Conexion
	 */
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "Rodrigo";
		String password = "Solomeo123"; // Poner su password
		String dataBase = "spotify";
		try {
			// Importando la libreria de conexion de mysql
			Class.forName("com.mysql.jdbc.Driver");
			// Url de conexion
			String urlConexion = "jdbc:mysql://" + host + "/" + dataBase + "?user=" + user + "&password=" + password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :')");
		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}

	// Ejercicio 1
	public ArrayList<String> getalbum() throws SQLException {
		ArrayList<String> lista= new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select distinct albums.title from albums\r\n" + 
				"inner join songs on songs.albumOrder = albums.id\r\n" + 
				"where duration < 5;");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			lista.add(rs.getString("title"));
		}
		rs.close();
		return lista;
	}
	//Ejercicio 2
	
	public ArrayList<String> getOwner() throws SQLException {
		ArrayList<String> lista= new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select owner from playlists\r\n" + 
				"inner join playlistsongs on playlists.id = playlistsongs.playlistId\r\n" + 
				"inner join songs on songs.id = playlistsongs.songId\r\n" + 
				"where songs.title = 'Extreme Action';");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			lista.add(rs.getString("owner"));
		}
		rs.close();
		return lista;
	}
	
	// Ejercicio 3 
	public ArrayList<String> getAlbumTitle() throws SQLException {
		ArrayList<String> lista= new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select albums.title from albums\r\n" + 
				"where albums.artist = (select artist from songs\r\n" + 
				"where plays = (select max(plays)  maximo from songs))");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			lista.add(rs.getString("title"));
		}
		rs.close();
		return lista;
	}
}