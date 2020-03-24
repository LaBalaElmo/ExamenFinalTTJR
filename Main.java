package spotify;

import java.sql.SQLException;
import java.util.ArrayList;

import spotify.Conector;

public class Main {
	public static void main(String[] args) {
//		Conector.getInstancia();
//		Conector instancia = Conector.getInstancia();
//		try {
//			ArrayList<String> listNombres = instancia.getalbum();
//			for(String nombre:listNombres) {
//				System.out.println(nombre);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		Conector instancia = Conector.getInstancia();
//		try {
//			ArrayList<String> listNombres = instancia.getOwner();
//			for(String nombre:listNombres) {
//				System.out.println(nombre);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		Conector instancia = Conector.getInstancia();
		try {
			ArrayList<String> listNombres = instancia.getAlbumTitle();
			for(String nombre:listNombres) {
				System.out.println(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
