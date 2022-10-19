package erdam.ej11.elecciones.mundo;

/**
 * votos de un rango de edad:
 */
public class VotoPorRangoDeEdad {
	//------- A T R I B U T O S -------//
	/**
	 * Representa la cantidad de votantes masculinos.
	 */
	private int cantidadHombres;
	/**
	 * Representa la cantidad de votantes femeninos.
	 */
	private int cantidadMujeres;
	/**
	 * Representa el rango de edad del votante.
	 */
	private Edad edad;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Crea los votos en un rango de edad. <br>
     * <b>post: </b> Se crearon los votos en el rango de edad. <br>
     * La cantidad de votos del género masculino fueron inicializados en 0. <br>
     * La cantidad de votos del género femenino fueron inicializados en 0.
	 * @param pEdad Rango de edad. pEdad pertenede a Edad.
	 */
	public VotoPorRangoDeEdad(Edad pEdad)
	{
		edad 				= pEdad;
		cantidadHombres 	= 0;
		cantidadMujeres		= 0;
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna la cantidad de votos masculinos.
	 * @return cantidad de votantes masculinos.
	 */

	public int getCantidadHombres() {
		return cantidadHombres;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad de votos femeninos.
	 * @return cantidad de votantes femeninos.
	 */
	public int getCantidadMujeres() {
		return cantidadMujeres;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el rango de edad.
	 * @return rango de edad.
	 */
	public Edad getEdad() {
		return edad;
	}
	
	//---------------------------------------------------//
	/**
	 * Registra el voto por género.
	 * <b>post: </b> Aumentó en uno la cantidad de votos según su género.
	 * @param pGenero Género al cual aumenta la cantidad de votos. pGenero === MASCULINO || pGenero === FEMENINO.
	 */
	public void registrarVoto(Genero pGenero)
	{
		if(pGenero.equals(Genero.MASCULINO))
		{
			cantidadHombres ++;
		}
		if(pGenero.equals(Genero.FEMENINO))
		{
			cantidadMujeres ++;
		}
		
	}
	//---------------------------------------------------//
	/**
	 * Retorna la totalidad de los votos.
	 * @return el total de votos.
	 */
	public int totalDeVotos()
	{
		int total = 0;
		total = cantidadHombres +cantidadMujeres;
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Reinicia el conteo de votos. <br>
     * <b>post: </b> La cantidad de votos masculinos y femeninos ahora es cero.
	 */
	public void reiniciar()
	{
		cantidadHombres 	= 0;
		cantidadMujeres		= 0;
	}

}
