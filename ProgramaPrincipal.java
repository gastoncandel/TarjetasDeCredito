package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class ProgramaPrincipal {
	
	static class Tarjetas {
		
		String Marca     ;
		int NumTarjeta   ;
		String cardHolder ;
		String FechaVencimiento;
	}
		
	
	
	public static void MostrarTasaOperacion (Tarjetas Origen) {
		float Tasa = CalcularTasa (Origen);
		String Marca = Origen.Marca;
		
		System.out.println("La Tasa de Operacion de "+Marca+" es de: "+Tasa);
	}
	
	
	public static float CalcularTasa (Tarjetas Origen) {
		
		float Tasa = 0;
		String Marca1 = Origen.Marca.toUpperCase();
		
		Calendar Calendario = new GregorianCalendar();
		int dia = Calendario.get(Calendar.DAY_OF_MONTH);
		int mes = Calendario.get(Calendar.MONTH) +1 ; // se suma 1 porque enero = cero
		int anio = Calendario.get(Calendar.YEAR);
		
		if (Marca1 == "VISA") {
			float ultimosDigitos = anio %100;
			
			Tasa = (float) (ultimosDigitos/mes);
			
		}
		
		if (Marca1 == "NARA") {
			Tasa = (float) (dia * 0.5) ;
		}
		
		if (Marca1 == "AMEX") {
			Tasa = (float)(mes * 0.1);
		}
		return Tasa;
	}

	public static void MostrarDatosTarjeta (Tarjetas Origen) {
		
		System.out.println("Los datos de la tarjeta son:");
		System.out.println("Marca: "+Origen.Marca);
		System.out.println("Numero de tarjeta: "+Origen.NumTarjeta);
		System.out.println("Card Holder: "+Origen.cardHolder);
		System.out.println("Vencimiento: "+Origen.FechaVencimiento);
		System.out.println("");
	}
	
	public static boolean ValidarOperacion (int A, int B) { // metodo para validar las operaciones
		return A<B;
	}
	
	
	
	
	public static boolean ValidarTarjeta (Tarjetas Origen) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date FechaActual = new Date();
		sdf.format(FechaActual);
		
		String FechaTarjeta = Origen.FechaVencimiento;
		
		Date FechaVencimiento = sdf.parse(FechaTarjeta);
		
		return FechaActual.before(FechaVencimiento);
		
	}
	

	public static void main(String[] args) throws ParseException {
		
		Tarjetas Tarjeta1 = new Tarjetas ();
		Tarjetas Tarjeta2 = new Tarjetas ();
		
		int ConsumoMaximo = 1000;
		int Consumo = 1414;  // 
		
		Tarjeta1.Marca= "VISA";
		Tarjeta1.NumTarjeta= 23562553;
		Tarjeta1.cardHolder= "Gaston candel";
		Tarjeta1.FechaVencimiento= "2025-07-01";
		
		Tarjeta2.Marca= "AMEX";
		Tarjeta2.NumTarjeta= 235623;
		Tarjeta2.cardHolder = "Ana Figueroa";
		
		MostrarDatosTarjeta(Tarjeta1);
	
	
		if(ValidarOperacion(Consumo, ConsumoMaximo)) {
			System.out.println("La operacion es valida");
		}else {
			System.out.println("Operacion invalida");
		}
		
		
		

		if (ValidarTarjeta(Tarjeta1)) {
			System.out.println("La tarjeta es valida ");
			
		}else{
			System.out.println("La tarjeta esta vencida ");
		}
		
		
		if (Tarjeta1.NumTarjeta == Tarjeta2.NumTarjeta) {
			System.out.println("los numeros de las tarjetas son iguales");
		}else {
			System.out.println("Los numeros de las tarjetas son distintos");
		}
		
		MostrarTasaOperacion (Tarjeta1);
		
		
	}

	
}
