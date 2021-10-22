package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Torneo;

public class Jsons {

	public static Torneo leerJson(String archivo) {
		Gson gson= new Gson();
		Torneo ret = null; 
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
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
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, Fecha[].class);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ret;
	}
	
	public static void generarJSON(String archivo , Torneo t) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(t);
		
		try {
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
