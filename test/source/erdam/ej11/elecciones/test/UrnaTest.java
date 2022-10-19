package erdam.ej11.elecciones.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.Medios;
import erdam.ej11.elecciones.mundo.Urna;

public class UrnaTest {
	//------- A T R I B U T O S -------//
	private Urna urna;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Construye una nueva Urna con 3 candidatos y sin votos.
     */
	private void setupEscenario1()
	{
		urna = new Urna();
	}
	//---------------------------------------------------//
	/**
     * Escenario 2: Construye una urna, donde cada candidato tiene un voto de cada medio de influencia.
     */
	private void setupEscenario2()
	{
		urna = new Urna();
		urna.votar(1, Edad.ADULTO, Genero.MASCULINO, Medios.TELEVISION);
		urna.votar(1, Edad.JOVEN, Genero.FEMENINO, Medios.INTERNET);
		urna.votar(1, Edad.MAYOR, Genero.MASCULINO, Medios.RADIO);
		urna.votar(2, Edad.ADULTO, Genero.MASCULINO, Medios.TELEVISION);
		urna.votar(2, Edad.JOVEN, Genero.FEMENINO, Medios.INTERNET);
		urna.votar(2, Edad.MAYOR, Genero.MASCULINO, Medios.RADIO);
		urna.votar(3, Edad.ADULTO, Genero.MASCULINO, Medios.TELEVISION);
		urna.votar(3, Edad.JOVEN, Genero.FEMENINO, Medios.INTERNET);
		urna.votar(3, Edad.MAYOR, Genero.MASCULINO, Medios.RADIO);
		
		
	}
	//--------- M � T O D O S  A  T E S T E A R ----------//
	/**
	 * Prueba 1: Verificar el m�todo constructor<br>
	 * <b>M�todo a probar:</b><br>
	 * Urna<br>
	 * getCandidato1<br>
	 * getCandidato2<br>
	 * getCandidato3<br>
	 * calcularTotalDeVotos<br>
	 * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
	@Test
	public void testUrna()
	{
		setupEscenario1();
		assertNotNull("El candidato 1 debe estar inicializado", urna.getCandidato1());
		assertNotNull("El candidato 2 debe estar inicializado", urna.getCandidato2());
		assertNotNull("El candidato 3 debe estar inicializado", urna.getCandidato3());
		assertEquals("La cantidad de votos totales deber�a ser cero", 0 , urna.calcularTotalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el m�todo buscar<br>
	 * <b>M�todod a probar:</b><br>
	 * buscar<br>
	 * <b> Caso de prueba</b><br>
	 * 1. El candidato existe<br>
	 * 2. El candidato no existe<br>
	 */
	@Test
	public void testBuscar()
	{
		setupEscenario1();
		assertNotNull("Deber�a existir el candidato 1",urna.buscar(1));
		assertNull("No deber�a existir el candidato 5", urna.buscar(5));
	}
	//---------------------------------------------------//
	/**
	 * Prueba 3: Verifica el m�todo votar<br>
	 * <b>M�todo a probar:</b><br>
	 * votar<br>
	 * getCandidato1<br>
	 * getCandidato2<br>
	 * getCandidato3<br>
	 * <b>Caso de prueba:</b>
	 * 1.Cada candidato tiene 3 votos, uno por cada rango de edad.<br>
	 */
	@Test
	public void testVotar()
	{
		setupEscenario2();
		assertEquals("Deber�a tener tres votos",3, urna.getCandidato1().cantidadVotosTotales());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato1().getVotoRango1().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato1().getVotoRango2().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato1().getVotoRango3().totalDeVotos());
		
		assertEquals("Deber�a tener tres votos",3, urna.getCandidato2().cantidadVotosTotales());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato2().getVotoRango1().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato2().getVotoRango2().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato2().getVotoRango3().totalDeVotos());
		
		assertEquals("Deber�a tener tres votos",3, urna.getCandidato3().cantidadVotosTotales());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato3().getVotoRango1().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato3().getVotoRango2().totalDeVotos());
		assertEquals("Deber�a tener un votos",1, urna.getCandidato3().getVotoRango3().totalDeVotos());
		
	}
	//---------------------------------------------------//
	/**
	 * Prueba 4: Verificar el m�todo calcularTotalDeVotos<br>
	 * <b>M�todo a probar</b><br>
	 * calcularTotalDeVotos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 * 
	 */
	@Test
	public void testCalcularTotalDeVotos()
	{
		setupEscenario2();
		assertEquals("El total de votos est� mal calculado.",9 ,urna.calcularTotalDeVotos() );
	}
	//---------------------------------------------------//
	/**
	 * Prueba 5: Verificar el m�todo calcularTotalDeVotosFemeninos. <br>
	 * <b>M�todo a probar:</b><br>
	 * calcularTotalDeVotosFemeninos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testCalcularTotalDeVotosFemeninos()
	{
		setupEscenario2();
		assertEquals("El total de los votos femeninos est� mal calculado",3 ,urna.calcularTotalDeVotosFemeninos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 6: Verificar el m�todo calcularTotalDeVotosMasculinos<br>
	 * <b>M�todo a probar:</b><br>
	 * calcularTotalDeVotosMasculinos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testCalcularTotalDeVotosMasculinos()
	{
		setupEscenario2();
		assertEquals("El total de los votos masculinos est� mal calculado",6,urna.calcularTotalDeVotosMasculinos());
	}
	//---------------------------------------------------//
	/**
	 * Probar 7: Verificar el m�tedo totalVotosPorEdad.<br>
	 * <b>M�todo a probar:</b><br>
	 * totalVotosPorEdad<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testTotalVotosPorEdad()
	{
		setupEscenario2();
		assertEquals("El total de votos hecho por jovenes est� mal calculado",3,urna.totalVotosPorEdad(Edad.JOVEN));
		assertEquals("El total de votos hecho por adultos est� mal calculado",3,urna.totalVotosPorEdad(Edad.ADULTO));
		assertEquals("El total de votos hecho por Mayores est� mal calculado",3,urna.totalVotosPorEdad(Edad.MAYOR));
	}
	//---------------------------------------------------//
	/**
	 * Prueba 8: Verificar el m�todo  calcularPromedioCostoCampania<br>
	 * <b>M�todo a probar:</b><br>
	 * calcularPromedioCostoCampania<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>  
	 */
	@Test
	public void testClcularPromedioCostoCampania()
	{
		setupEscenario2();
		assertEquals("El calculo del promedio de la campa�a es incorrecto",1600 , urna.calcularPromedioCostoCampania(),0.001);
	}
	/**
	 * Prueba 9: Verificar el m�todo  calcularPromedioVotosCandidato<br>
	 * <b>M�todo a probar:</b><br>
	 * calcularPromedioVotosCandidato<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>  
	 */
	@Test
	public void testCalcularPromedioVotosCandidato()
	{
		setupEscenario2();
		assertEquals("El porcentaje de votos est� mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(1),0.01);
		assertEquals("El porcentaje de votos est� mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(2),0.01);
		assertEquals("El porcentaje de votos est� mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(3),0.01);
		
	}
	//---------------------------------------------------//

    /**
     * Prueba 10: Verifica el m�todo reiniciar.<br>
     * <b> M�todos a probar: </b> <br>
     * reiniciar<br>
     * calcularTotalVotos<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Cada candidato tiene 3 votos, uno por cada rango de edad.<br>
     */
    @Test
    public void testReiniciar( )
    {
    	setupEscenario2();
    	urna.reiniciar();
    	assertEquals("El total de votos est� mal calculado.",0 ,urna.calcularTotalDeVotos() );
    }
}
