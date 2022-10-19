package erdam.ej11.elecciones.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.VotoPorRangoDeEdad;
/**
 * Clase usada para verificar que los m�todos de la clase VotoPorRangoDeEdad est�n correctamente implementados.
 */
public class VotoPorRangoDeEdadTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase con las que se deber�n hacer las pruebas.
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
	//--------- M � T O D O S  A  T E S T E A R ----------//
	/**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
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
		assertEquals("La cantidad de mujeres electoras deber�a ser 0", 0, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores deber�a ser 0", 0, porRangoDeEdad.getCantidadHombres());
		assertEquals("El total de votos deber�a ser 0", 0, porRangoDeEdad.totalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el m�todo registrarVoto. <br>
	 * <b> M�todos a probar </b> <br>
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
		assertEquals("La cantidad de mujeres electoras deber�a ser de 2", 2, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores deber�a ser de 1", 1, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos deber�a ser de 3", 3, porRangoDeEdad.totalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 3: Verifica el m�todo reiniciar. <br>
	 * <b>M�todo a probar</<b> <br>
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
		assertEquals("La cantidad de mujeres electoras deber�a ser de 2", 2, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores deber�a ser de 1", 1, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos deber�a ser de 3", 3, porRangoDeEdad.totalDeVotos());
		porRangoDeEdad.reiniciar();
		assertEquals("La cantidad de mujeres electoras deber�a ser de 0", 0, porRangoDeEdad.getCantidadMujeres());
		assertEquals("La cantidad de hombres electores deber�a ser de 0",0, porRangoDeEdad.getCantidadHombres());
		assertEquals("La cantidad total de votos deber�a ser de 0", 0, porRangoDeEdad.totalDeVotos());
		
		
	}
	
}
