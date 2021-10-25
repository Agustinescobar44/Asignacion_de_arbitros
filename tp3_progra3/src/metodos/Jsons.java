package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Torneo;

public class Jsons {

	public static Torneo leerTorneoDeJson(String archivo) {
		Gson gson= new Gson();
		Torneo ret = null; 
	
		try {
			BufferedReader br = new BufferedReader(new FileReader("tp3_progra3\\src\\archivos\\"+archivo));
			ret = gson.fromJson(br, Torneo.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ret;
	
	}
	
	public  static Fecha[] leerFechasDeJson(String archivo) {
		
		Gson gson = new Gson();
		Fecha[] ret = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tp3_progra3\\src\\archivos\\"+archivo));
			ret = gson.fromJson(br, Fecha[].class);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ret;
	}
	public  static Equipo leerEquipoDeJson(String archivo) {
		
		Gson gson = new Gson();
		Equipo ret = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tp3_progra3\\src\\archivos\\"+archivo));
			ret = gson.fromJson(br, Equipo.class);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ret;
	}
	
	public static void generarJSON(String archivo , Torneo t) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(t);
		
		try {
			FileWriter writer = new FileWriter("tp3_progra3\\src\\archivos\\"+archivo);
			writer.write(json);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void generarJSON(String archivo , Fecha f) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(f);
		
		try {
			FileWriter writer = new FileWriter("tp3_progra3\\src\\archivos\\"+archivo);
			writer.write(json);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void generarJSON(String archivo , Equipo equipo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(equipo);
		
		try {
			FileWriter writer = new FileWriter("tp3_progra3\\src\\archivos\\"+archivo);
			writer.write(json);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
