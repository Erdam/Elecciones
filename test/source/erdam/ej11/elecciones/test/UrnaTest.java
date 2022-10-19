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
	//--------- M É T O D O S  A  T E S T E A R ----------//
	/**
	 * Prueba 1: Verificar el método constructor<br>
	 * <b>Método a probar:</b><br>
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
		assertEquals("La cantidad de votos totales debería ser cero", 0 , urna.calcularTotalDeVotos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el método buscar<br>
	 * <b>Métodod a probar:</b><br>
	 * buscar<br>
	 * <b> Caso de prueba</b><br>
	 * 1. El candidato existe<br>
	 * 2. El candidato no existe<br>
	 */
	@Test
	public void testBuscar()
	{
		setupEscenario1();
		assertNotNull("Debería existir el candidato 1",urna.buscar(1));
		assertNull("No debería existir el candidato 5", urna.buscar(5));
	}
	//---------------------------------------------------//
	/**
	 * Prueba 3: Verifica el método votar<br>
	 * <b>Método a probar:</b><br>
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
		assertEquals("Debería tener tres votos",3, urna.getCandidato1().cantidadVotosTotales());
		assertEquals("Debería tener un votos",1, urna.getCandidato1().getVotoRango1().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato1().getVotoRango2().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato1().getVotoRango3().totalDeVotos());
		
		assertEquals("Debería tener tres votos",3, urna.getCandidato2().cantidadVotosTotales());
		assertEquals("Debería tener un votos",1, urna.getCandidato2().getVotoRango1().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato2().getVotoRango2().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato2().getVotoRango3().totalDeVotos());
		
		assertEquals("Debería tener tres votos",3, urna.getCandidato3().cantidadVotosTotales());
		assertEquals("Debería tener un votos",1, urna.getCandidato3().getVotoRango1().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato3().getVotoRango2().totalDeVotos());
		assertEquals("Debería tener un votos",1, urna.getCandidato3().getVotoRango3().totalDeVotos());
		
	}
	//---------------------------------------------------//
	/**
	 * Prueba 4: Verificar el método calcularTotalDeVotos<br>
	 * <b>Método a probar</b><br>
	 * calcularTotalDeVotos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 * 
	 */
	@Test
	public void testCalcularTotalDeVotos()
	{
		setupEscenario2();
		assertEquals("El total de votos está mal calculado.",9 ,urna.calcularTotalDeVotos() );
	}
	//---------------------------------------------------//
	/**
	 * Prueba 5: Verificar el método calcularTotalDeVotosFemeninos. <br>
	 * <b>Método a probar:</b><br>
	 * calcularTotalDeVotosFemeninos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testCalcularTotalDeVotosFemeninos()
	{
		setupEscenario2();
		assertEquals("El total de los votos femeninos está mal calculado",3 ,urna.calcularTotalDeVotosFemeninos());
	}
	//---------------------------------------------------//
	/**
	 * Prueba 6: Verificar el método calcularTotalDeVotosMasculinos<br>
	 * <b>Método a probar:</b><br>
	 * calcularTotalDeVotosMasculinos<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testCalcularTotalDeVotosMasculinos()
	{
		setupEscenario2();
		assertEquals("El total de los votos masculinos está mal calculado",6,urna.calcularTotalDeVotosMasculinos());
	}
	//---------------------------------------------------//
	/**
	 * Probar 7: Verificar el métedo totalVotosPorEdad.<br>
	 * <b>Método a probar:</b><br>
	 * totalVotosPorEdad<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>
	 */
	@Test
	public void testTotalVotosPorEdad()
	{
		setupEscenario2();
		assertEquals("El total de votos hecho por jovenes está mal calculado",3,urna.totalVotosPorEdad(Edad.JOVEN));
		assertEquals("El total de votos hecho por adultos está mal calculado",3,urna.totalVotosPorEdad(Edad.ADULTO));
		assertEquals("El total de votos hecho por Mayores está mal calculado",3,urna.totalVotosPorEdad(Edad.MAYOR));
	}
	//---------------------------------------------------//
	/**
	 * Prueba 8: Verificar el método  calcularPromedioCostoCampania<br>
	 * <b>Método a probar:</b><br>
	 * calcularPromedioCostoCampania<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>  
	 */
	@Test
	public void testClcularPromedioCostoCampania()
	{
		setupEscenario2();
		assertEquals("El calculo del promedio de la campaña es incorrecto",1600 , urna.calcularPromedioCostoCampania(),0.001);
	}
	/**
	 * Prueba 9: Verificar el método  calcularPromedioVotosCandidato<br>
	 * <b>Método a probar:</b><br>
	 * calcularPromedioVotosCandidato<br>
	 * <b>Caso de prueba</b><br>
	 * 1. Cada candidato tiene 3 voros, uno por cada rango de edad.<br>  
	 */
	@Test
	public void testCalcularPromedioVotosCandidato()
	{
		setupEscenario2();
		assertEquals("El porcentaje de votos está mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(1),0.01);
		assertEquals("El porcentaje de votos está mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(2),0.01);
		assertEquals("El porcentaje de votos está mal calculado.", 33.33 , urna.calcularPromedioVotosCandidato(3),0.01);
		
	}
	//---------------------------------------------------//

    /**
     * Prueba 10: Verifica el método reiniciar.<br>
     * <b> Métodos a probar: </b> <br>
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
    	assertEquals("El total de votos está mal calculado.",0 ,urna.calcularTotalDeVotos() );
    }
}
