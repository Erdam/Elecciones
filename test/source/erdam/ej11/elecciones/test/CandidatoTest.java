package erdam.ej11.elecciones.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import erdam.ej11.elecciones.mundo.Candidato;
import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.Medios;
/**
 * Clase usada para verificar que los métodos de la clase Candidato estén correctamente implementados.
 */
public class CandidatoTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase con las que se deberán hacer las pruebas.
	 */
	private Candidato candidato;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Construye un nuevo Candidato sin votos.
     */
	private void setupEscenario()
	{
		candidato = new Candidato("Erdam", "Techera", 46, "Ecologista", 1);
	
	}
	//--------- M É T O D O S  A  T E S T E A R ----------//

	/**
	 * Prueba 1: Verifica el método constructor. <br> 
	 * <b>Método a probar:</b> <br> 
	 * Candidato  <br> 
	 * getNombre  <br> 
	 * getApellido  <br> 
	 * getEdad  <br> 
	 * getPartido  <br> 
	 * getNumero  <br> 
	 * getCostoDeCampania <br>
	 * cantidadVotosTotales() <br>
	 * <b>Casos de prueba:</b> <br>
	 * 1. Los valores de los atributos corresponden.
	 */
	@Test
	public void testCandidato()
	{
		setupEscenario();
		assertEquals("No es el nombre dado por parámetro","Erdam",candidato.getNombre());
		assertEquals("No es el apellido dado por parámetro","Techera",candidato.getApellido());
		assertEquals("La edad no corresponde con la edad pasada por parámetros", 46, candidato.getEdad());
		assertEquals("No es el Partido Político dado por parámetro","Ecologista",candidato.getPartidoPolitico());
		assertEquals("No corresponde al número de candidato pasado por parámetros", 1, candidato.getNumero());
		assertEquals("El costo de la campaña debería ser cero", 0, candidato.getCostoDeCampania(),0.00);
		assertEquals("La cantidad de votos debería ser cero", 0, candidato.cantidadVotosTotales());

	}
	
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el método registarVoto. <br>
	 * <b>Método a probar</b> <br>
	 * registarVoto<br>
	 * totalVotosMasculino<br>
	 * totalVotosFemenino<br<br>>
	 * cantidadVotosTotales
	 * getCostoDeCampania<br>
	 * <b> Casos de prueba: </b> <br>
     * 1. Se registra un voto del rango 1 del género femenino con medio televisión.<br>
     * 2. Se registra un voto del rango 2 del género femenino con medio radio.<br>
     * 3. Se registra un voto del rango 3 del género femenino con medio internet.<br>
     * 4. Se registra un voto del rango 1 del género masculino con medio televisión.<br>
     * 5. Se registra un voto del rango 2 del género masculino con medio radio.<br>
     * 6. Se registra un voto del rango 3 del género masculino con medio internet.<br>
     */

	@Test
	public void testRegistrarVotos()
	{
		setupEscenario();
		//          1
		candidato.registarVoto(Edad.JOVEN, Genero.FEMENINO, Medios.TELEVISION);
		assertEquals("La cantidad de votos femeninos debería ser 1", 1,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 0", 0,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 1", 1,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $1000",1000,candidato.getCostoDeCampania(),0.0001);
		
		//          2
		candidato.registarVoto(Edad.ADULTO, Genero.FEMENINO, Medios.RADIO);
		assertEquals("La cantidad de votos femeninos debería ser 2", 2,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 0", 0,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 2", 2,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $1500",1500,candidato.getCostoDeCampania(),0.0001);
		
		//          3
		candidato.registarVoto(Edad.MAYOR, Genero.FEMENINO, Medios.INTERNET);
		assertEquals("La cantidad de votos femeninos debería ser 3", 3,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 0", 0,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 3", 3,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $1600",1600,candidato.getCostoDeCampania(),0.0001);
		
		//          4
		candidato.registarVoto(Edad.JOVEN, Genero.MASCULINO, Medios.TELEVISION);
		assertEquals("La cantidad de votos femeninos debería ser 3", 3,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 1", 1,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 4", 4,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $2600",2600,candidato.getCostoDeCampania(),0.0001);
		
		//          5
		candidato.registarVoto(Edad.ADULTO, Genero.MASCULINO, Medios.RADIO);
		assertEquals("La cantidad de votos femeninos debería ser 3", 3,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 2", 2,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 5", 5,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $3100",3100,candidato.getCostoDeCampania(),0.0001);
		
		//          6
		candidato.registarVoto(Edad.MAYOR, Genero.MASCULINO, Medios.INTERNET);
		assertEquals("La cantidad de votos femeninos debería ser 3", 3,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 3", 3,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 6", 6,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $3200",3200,candidato.getCostoDeCampania(),0.0001);
			
	}
	//---------------------------------------------------//
    /**
     * Prueba 3: Verifica el método reinicio.<br>
     * <b> Métodos a probar: </b> <br>
     * registarVoto<br>
	 * totalVotosMasculino<br>
	 * totalVotosFemenino<br>
	 * cantidadVotosTotales<br>
	 * getCostoDeCampania<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay 3 votos por género, de los cuales hay 1 por cada medio y cada rango de edad.
     */
	@Test 
	public void testReiniciar()
	{
		setupEscenario();

		assertEquals("La cantidad de votos femeninos debería ser 0", 0,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 0", 0,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 0", 0,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $0",0,candidato.getCostoDeCampania(),0.0001);
		candidato.registarVoto(Edad.JOVEN, Genero.FEMENINO, Medios.TELEVISION);
		candidato.registarVoto(Edad.ADULTO, Genero.FEMENINO, Medios.RADIO);
		candidato.registarVoto(Edad.MAYOR, Genero.FEMENINO, Medios.INTERNET);
		candidato.registarVoto(Edad.JOVEN, Genero.MASCULINO, Medios.TELEVISION);
		candidato.registarVoto(Edad.ADULTO, Genero.MASCULINO, Medios.RADIO);
		candidato.registarVoto(Edad.MAYOR, Genero.MASCULINO, Medios.INTERNET);
		assertEquals("La cantidad de votos femeninos debería ser 3", 3,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 3", 3,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 6", 6,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $3200",3200,candidato.getCostoDeCampania(),0.0001);
		candidato.reinicio();
		assertEquals("La cantidad de votos femeninos debería ser 0", 0,candidato.totalVotosFemenino());
		assertEquals("La cantidad de votos Masculinos debería ser 0", 0,candidato.totalVotosMasculino());
		assertEquals("La cantidad de votos totales debería ser 0", 0,candidato.cantidadVotosTotales());
		assertEquals("El costo de la campaña debería ser de $0",0,candidato.getCostoDeCampania(),0.0001);
		
	}
}
