package erdam.ej11.elecciones.mundo;
/**
 * Urna de votación con tres candidatos.
 */

public class Urna {
	//------- A T R I B U T O S -------//
	/**
	 * Representa el candidato 1.
	 */
	private Candidato candidato1;
	/**
	 * Representa el candidato 2.
	 */
	private Candidato candidato2;
	/**
	 * Representa el candidato 3.
	 */
	private Candidato candidato3;
	//----- C O N S T R U C T O R  -----//
    /**
     * Inicializa los tres candidatos. <br>
     * <b>post: </b> Se inicializaron los tres candidatos con los siguientes valores: <br>
     * Candidato1 - Nombre: Laura, Apellido: Contamina, Partido político: Ecologico, Edad: 35, Número: 1. <br>
     * Candidato2 - Nombre: Dolore, Apellido: Delano, Partido político: Partido Conservador, Edad: 42, Número: 2. <br>
     * Candidato3 - Nombre: Mary, Apellido: Conazo, Partido político: Partido Camino Cristiano, Edad: 81, Número: 3.
     */
	public Urna()
	{
		candidato1 = new Candidato("Laura", "Contamina", 35, "Ecológico", 1);
		candidato2 = new Candidato("Dolores", "Delano", 42, "Conservador", 2);
		candidato3 = new Candidato("Mary", "Conazo", 81, "Camino Cristiano", 3);
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna el candidato 1.
	 * @return candidato 1.
	 */
	public Candidato getCandidato1() {
		return candidato1;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el candidato 2.
	 * @return candidato 2.
	 */
	public Candidato getCandidato2() {
		return candidato2;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el candidato 3.
	 * @return candidato 3.
	 */
	public Candidato getCandidato3() {
		return candidato3;
	}
	
	//---------------------------------------------------//
	/**
	 * Busca al candidato con el número dado.
	 * @param pNumero Número del candidato a buscar. pNumero > 0 && pNumero < 4.
	 * @return El candidato con el número dado, null si no lo encuentra.
	 */
	public Candidato buscar(int pNumero)
	{
		Candidato buscado = null;
		
		if(candidato1.getNumero()==pNumero)
		{
			buscado = candidato1;
		}
		else if(candidato2.getNumero()==pNumero)
		{
			buscado = candidato2;
		}
		else if(candidato3.getNumero()==pNumero)
		{
			buscado = candidato3;
		}

		return buscado;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el total de votos en un rango de edad específico.
	 * @param pEdad Edad del rango. pEdad == JOVEN || pEdad == MEDIA || pEdad == MAYOR.
	 * @return Total de votos en el rango de edad.
	 */
	public int totalVotosPorEdad(Edad pEdad)
	{
		int total = 0;
		switch (pEdad)
		{
		case JOVEN:
			total = candidato1.getVotoRango1().totalDeVotos() +
					candidato2.getVotoRango1().totalDeVotos() +
					candidato3.getVotoRango1().totalDeVotos();
			break;
		case ADULTO:
			total = candidato1.getVotoRango2().totalDeVotos() +
					candidato2.getVotoRango2().totalDeVotos() +
					candidato3.getVotoRango2().totalDeVotos();
			break;
		case MAYOR:
			total = candidato1.getVotoRango3().totalDeVotos() +
					candidato2.getVotoRango3().totalDeVotos() +
					candidato3.getVotoRango3().totalDeVotos();
			break;
		
		}
		return total;

	}
	//---------------------------------------------------//
	/**
	 * Retorna el total de los votos en la urna.
	 * @return total de votos.
	 */

	public int calcularTotalDeVotos()
	{
		int total = 0;
		total = candidato1.cantidadVotosTotales() + 
				candidato2.cantidadVotosTotales() +
				candidato3.cantidadVotosTotales();
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el total de votos femeninos.
	 * @return total de votos femeninos.
	 */
	public int calcularTotalDeVotosFemeninos()
	{
		int total = 0;
		total = candidato1.totalVotosFemenino() + 
				candidato2.totalVotosFemenino() +
				candidato3.totalVotosFemenino();
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el total de votos masculinos.
	 * @return total de votos masculinos.
	 */
	public int calcularTotalDeVotosMasculinos()
	{
		int total = 0;
		total = candidato1.totalVotosMasculino() + 
				candidato2.totalVotosMasculino() +
				candidato3.totalVotosMasculino();
		return total;
	}
	//---------------------------------------------------//
	/**
	 * Retotna el costo promedio de la campaña.
	 * @return costo promedio de la campaña.
	 */
	public double calcularPromedioCostoCampania()
	{
		double total = 0;
		total = candidato1.getCostoDeCampania() +
				candidato2.getCostoDeCampania() +
				candidato3.getCostoDeCampania();
		return (total/3);
	}
	//---------------------------------------------------//
	/**
	 * Retotna el promedio de votos de un candidato pasado por parámetro.
	 * @param pNumero Número asociado a un candidato. pNumero > 0 && pNumero < 4.
	 * @return promedio de votos que generó el candidato pasado por parámetro.
	 */
	public double calcularPromedioVotosCandidato(int pNumero)
	{
		double votosAlCandidato = buscar(pNumero).cantidadVotosTotales();
		double votosTotales = calcularTotalDeVotos();
		return votosAlCandidato/votosTotales * 100;
	
	}
	//---------------------------------------------------//
	/**
	 * Registra un voto al candidato con el número pasado por parámetro.<be>
	 * <b>post: </b> Los votos del candidato aumentaron en uno en el rango y género dado. <br>
     * Aumentó el costo de campaña del candidato.
	 * @param pNumero Número que identifica al candidato.  pNumero > 0 && pNumero < 4.
	 * @param pEdad Rango de edad del elector. pEdad == JOVEN || pEdad == MEDIA || pEdad == MAYOR.
	 * @param pGenero  Género del elector. pGenero == MASCULINO || pGenero == FEMENINO. 
	 * @param pMedios  Medio de influencia que influenció el voto. pMedios == TELEVISION || pMedios == RADIO || pMedios == INTERNET.
	 */
	public void votar(int pNumero, Edad pEdad, Genero pGenero,Medios pMedios)
	{
		Candidato buscado = null;
		buscado = buscar(pNumero);
		if(buscado !=null)
		{
			buscado.registarVoto(pEdad, pGenero, pMedios);
		}
		
	}
	//---------------------------------------------------//
	/**
	 * Reinicia todos los valores de los candidatos.
	 * <b>post: </b> Los votos de los 3 candidatos fueron reiniciados.
	 */
	public void reiniciar()
	{
		candidato1.reinicio();
		candidato2.reinicio();
		candidato3.reinicio();
	}
	
}
