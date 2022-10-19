package erdam.ej11.elecciones.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.VotoPorRangoDeEdad;
/**
 * Clase usada para verificar que los métodos de la clase VotoPorRangoDeEdad estén correctamente implementados.
 */
public class VotoPorRangoDeEdadTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase con las que se deberán hacer las pruebas.
	 */
	private VotoPorRangoDeEdad porRangoDeEdad;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Construye un nuevo VotosRangoEdad con Edad Joven.
     */
	private void setupEscenario()
	{
		porRangoDeEdad = new VotoPorRangoDeEdad(Edad.JOVEN);
		
	}
	//--------- M É T O D O S  A  T E S T E A R ----------//
	/**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * VotoPorRangoDeEdad<br>
     * getEdad<br>
     * getCantidadMujeres<br>
     * getCantidadHombres<br>
     * totalDeVotos<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
	@Test
	public void testVotoPorRangoDeEdad()
	{
		setupEscenario();
		assertTrue("El rango de edad no corresponde", porRangoDeEdad.getEdad().equals(Edad.JOVEN));
		assertEquals("La cantidad de mujeres electoras debería ser 0", 0, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores debería ser 0", 0, porRangoDeEdad.getCantidadHombres());
		assertEquals("El total de votos debería ser 0", 0, porRangoDeEdad.totalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el método registrarVoto. <br>
	 * <b> Métodos a probar </b> <br>
	 * registrarVoto <br>
     * getCantidadMujeres<br>
     * getCantidadHombres<br>
     * totalDeVotos<br>
     * <b> Casos de prueba</b> <br>
     * 1. Se registra un voto masculino. <br>
     * 2. Se registra un voto femenino. <br>
     * 3. Se registra un voto femenino. <br>
	 */
	@Test
	public void testRegistrarVoto()
	{
		setupEscenario();
		porRangoDeEdad.registrarVoto(Genero.FEMENINO);
		porRangoDeEdad.registrarVoto(Genero.FEMENINO);
		porRangoDeEdad.registrarVoto(Genero.MASCULINO);
		assertEquals("La cantidad de mujeres electoras debería ser de 2", 2, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores debería ser de 1", 1, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos debería ser de 3", 3, porRangoDeEdad.totalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 3: Verifica el método reiniciar. <br>
	 * <b>Método a probar</<b> <br>
	 * reiniciar <br>
	 * registrarVoto <br>
     * getCantidadMujeres<br>
     * getCantidadHombres<br>
     * totalDeVotos<br>  
     * <b> Casos de prueba</b> <br>
     * 1. Se registra un voto masculino y dos voto femenino. <br>
	 */
	@Test
	public void testReiniciar()
	{
		setupEscenario();
		porRangoDeEdad.registrarVoto(Genero.FEMENINO);
		porRangoDeEdad.registrarVoto(Genero.FEMENINO);
		porRangoDeEdad.registrarVoto(Genero.MASCULINO);
		assertEquals("La cantidad de mujeres electoras debería ser de 2", 2, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores debería ser de 1", 1, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos debería ser de 3", 3, porRangoDeEdad.totalDeVotos());
		porRangoDeEdad.reiniciar();
		assertEquals("La cantidad de mujeres electoras debería ser de 0", 0, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores debería ser de 0",0, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos debería ser de 0", 0, porRangoDeEdad.totalDeVotos());
		
		
	}
	
}
