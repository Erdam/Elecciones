package erdam.ej11.elecciones.mundo;
/**
 * Candidato de la urna elecciones
 */
public class Candidato {
	// ------- C O N S T A N T E S -------//
	private static final double COSTO_TV 			= 1000;
	private static final double COSTO_RADIO 		= 500;
	private static final double COSTO_INTERNET		= 100;
	//------- A T R I B U T O S -------//
	private String nombre;
	private String apellido;
	private int edad;
	private String partidoPolitico;
	private double costoDeCampania;
	private int numero;
	private VotoPorRangoDeEdad votoRango1;
	private VotoPorRangoDeEdad votoRango2;
	private VotoPorRangoDeEdad votoRango3;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Crea le candidato con los valores pasados por parámetro.<br>
	 * <b>post:</b> El nombre, apellido, edad, partido político y el número de candidato fueron inicializados con los valores dados por parámetros.
	 * El costo de campaña se inicializó en cero. <br>
     * Los votos por rango de edad fueron inicializados con los siguientes valores: <br>
     * Rango1 - Edad: Joven. <br>
     * Rango2 - Edad: Media. <br>
     * Rango3 - Edad: Mayor.
	 * @param pNombre Nombre del candidato. pNombre !=null && pNombre !="".
	 * @param pApellido Apellido del candidato. pApellido !=null && pApellido !="".
	 * @param pEdad Edad del candidato. pEdad >=18 .
	 * @param pPartidoPolitico Partido político que pertenece el candidato. pPartidoPolitico !=null && pPartidoPolitico !="".
	 * @param pNumeroCandidato Número del candidato. pNumeroCandidato >0 && pNumeroCandidato <4.
	 */

	public Candidato(String pNombre, String pApellido, int pEdad, String pPartidoPolitico, int pNumeroCandidato)
	{
		nombre 						= pNombre;
		apellido 					= pApellido;
		edad            			= pEdad;
		partidoPolitico 			= pPartidoPolitico;
		numero          			= pNumeroCandidato;
		costoDeCampania 			= 0;
		votoRango1 					= new VotoPorRangoDeEdad(Edad.JOVEN);
		votoRango2 					= new VotoPorRangoDeEdad(Edad.ADULTO);
		votoRango3 					= new VotoPorRangoDeEdad(Edad.MAYOR);
		
	}
	//--------- M É T O D O S ----------//
	//---------------------------------------------------//
	/**
	 * Retorna el nombre del candidato.
	 * @return Nombre del candidato.
	 */
	public String getNombre() {
		return nombre;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el apellido del candidato.
	 * @return Apellido del candidato.
	 */
	public String getApellido() {
		return apellido;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la edad del candidato.
	 * @return Edad del candidato
	 */
	public int getEdad() {
		return edad;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el costo de la campaña.
	 * @return Costo de campaña.
	 */
	public double getCostoDeCampania() {
		return costoDeCampania;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el número que identifica al candidato.
	 * @return Número del candidato.
	 */
	public int getNumero() {
		return numero;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el partido político del candidato.
	 * @return Partido político.
	 */
	public String getPartidoPolitico() {
		return partidoPolitico;
	}
	//---------------------------------------------------//
	/**
	 * Retorna los votos del rango 1.
	 * @return votos del rango 1.
	 */
	public VotoPorRangoDeEdad getVotoRango1() {
		return votoRango1;
	}
	//---------------------------------------------------//
	/**
	 * Retorna los votos del rango2.
	 * @return votos del rango 2.
	 */
	public VotoPorRangoDeEdad getVotoRango2() {
		return votoRango2;
	}
	//---------------------------------------------------//
	/**
	 * Retorna los votos del rango 3.
	 * @return votos del rango 3.
	 */
	public VotoPorRangoDeEdad getVotoRango3() {
		return votoRango3;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad total de los votos.
	 * @return cantidad total de los votos.
	 */
	public int cantidadVotosTotales()
	{
		int total = 0;
		total = votoRango1.totalDeVotos() +
				votoRango2.totalDeVotos() +
				votoRango3.totalDeVotos();
		return total;
	}

	//---------------------------------------------------//
	/**
	 * Retorna la cantidad total de los votos masculinos.
	 * @return total de votos masculinos.
	 */
	public int totalVotosMasculino()
	{
		int total = 0;
		total =  votoRango1.getCantidadHombres() +
				votoRango2.getCantidadHombres() +
				votoRango3.getCantidadHombres();
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad total de votos femeninos.
	 * @return total de votos femeninos.
	 */
	public int totalVotosFemenino()
	{
		int total = 0;
		total =  votoRango1.getCantidadMujeres() +
				votoRango2.getCantidadMujeres() +
				votoRango3.getCantidadMujeres();
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Registra un voto por rango de edad, género y medio de influencia pasados por parámetros.<br>
	 * <b>post:</b> La cantidad de votos por el rango de edad y genero aumentó en uno.<br>
	 * El costo de la campaña aumentó según el medio de influencia pasado por parámetros.
	 * @param pEdad Rango de edad del elector. pEdad == JOVEN || pEdad == MEDIA || pEdad == MAYOR.
	 * @param pGenero Género del elector. pGenero == MASCULINO || pGenero == FEMENINO. 
	 * @param pMedios Medio de influencia que influenció el voto. pMedios == TELEVISION || pMedios == RADIO || pMedios == INTERNET.
	 */
	public void registarVoto(Edad pEdad,Genero pGenero,Medios pMedios)
	{
		switch (pEdad) {
		case JOVEN:
			  votoRango1.registrarVoto(pGenero);
			break;
		case ADULTO:
			  votoRango2.registrarVoto(pGenero);
			break;
		case MAYOR:
			  votoRango3.registrarVoto(pGenero);
			break;
		}
		
		switch (pMedios) {
		case TELEVISION:
			  costoDeCampania += COSTO_TV;
			break;
		case RADIO:
			 costoDeCampania += COSTO_RADIO;
			break;
		case INTERNET:
			 costoDeCampania += COSTO_INTERNET;
			break;
		}
		
	}
	//---------------------------------------------------//
	public void reinicio()
	{
		votoRango1.reiniciar();
		votoRango2.reiniciar();
		votoRango3.reiniciar();
		costoDeCampania = 0;
		
	}

}
