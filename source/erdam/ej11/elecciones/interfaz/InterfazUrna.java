package erdam.ej11.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.UIManager;

import erdam.ej11.elecciones.mundo.Candidato;
import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.Medios;
import erdam.ej11.elecciones.mundo.Urna;

@SuppressWarnings("serial")
/**
 * Ventana principal de la aplicación.
 */
public class InterfazUrna extends JFrame {

	//------- A T R I B U T O S -------//
	/**
	 * Panel del banner.
	 */
	private PanelBanner 		banner;
	private PanelCandidato 		candidato1;
	private PanelCandidato 		candidato2;
	private PanelCandidato 		candidato3;
	private PanelBotones   		botones;
	/**
	 * Clase principal del mundo.
	 */
	private Urna 			urna;
	//----- C O N S T R U C T O R  -----//

	public InterfazUrna()
	{
		urna = new Urna();
		setTitle("Elecciones");
		setSize(750,780);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCandidatos  = new JPanel();
		setLayout(new BorderLayout());
		banner 					= new PanelBanner();
		candidato1 				= new PanelCandidato(this, 1);
		candidato2 				= new PanelCandidato(this, 2);
		candidato3 				= new PanelCandidato(this, 3);
		botones                 = new PanelBotones(this);
		panelCandidatos.setLayout(new GridLayout(1,3,5,5));
		panelCandidatos.add(candidato1);
		panelCandidatos.add(candidato2);
		panelCandidatos.add(candidato3);
		 //-----------Dibujar-----------//
		getContentPane().add(banner, BorderLayout.NORTH);
		getContentPane().add(panelCandidatos, BorderLayout.CENTER);
		getContentPane().add(botones, BorderLayout.SOUTH);

		
		
		setLocationRelativeTo(null);
		setResizable(false);
		actualizarInforme();
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Registra un voto a un candidato dado el medio de influencia, la edad y el género del elector.<br>
	 * <b>post: </b> Se registró un voto al candidato con el número dado.
	 * @param pNumeroCandidato Numero de lista del candidato. pNumeroCandidato > 0 && pNumeroCandidato < 4. 
	 * @param pEdad Rango de edad del elector. pEdad==JOVEN || pEdad==ADULTO || pEdad==MAYOR.
	 * @param pGenero Género del elector. pGenero==MASCULINO || pGenero==FEMENINO.
	 * @param pGenero Medio de influencia del electorado. pGenero==TELEVISION || pGenero==RADIO || pGenero==INTERNET.
	 */
	public void votar(int pNumeroCandidato, Edad pEdad, Genero pGenero, Medios pMedios)
	{
		urna.votar(pNumeroCandidato, pEdad, pGenero, pMedios);
		actualizarInforme();
		
	}
	//---------------------------------------------------//
	/**
	 * Retorna el total de votos de la urna.
	 * @return Total de votos de la urna
	 */
	public int getTotalDeVotos()
	{
		return urna.calcularTotalDeVotos();
	}
	//---------------------------------------------------//
	/**
	 * Muestra el dialogo para votar.
	 * @param pNumeroCandidato Número del candidato al cual se vota. pNumeroCandidato > 0 && pNumeroCandidato < 4.
	 */
	public void getDialogoVotar(int pNumeroCandidato)
	{
		DialogoVotar votar = new DialogoVotar(this, pNumeroCandidato);
		votar.setVisible(true);
	}
	//---------------------------------------------------//

	/**
	 * Muestra el dialogo de estadistica de un candidato. 
	 * @param pNumeroCandidato Número del candidato al cual se vota. pNumeroCandidato > 0 && pNumeroCandidato < 4.
	 */
	public void getDialogoEstadisticaCandidato(int pNumeroCandidato)
	{
		 Candidato candidato = urna.buscar(pNumeroCandidato);
		 DialogoEstadisticaCandidato dialogo = new DialogoEstadisticaCandidato( this, candidato );
	        dialogo.setVisible( true );
		
	}
	//---------------------------------------------------//
	/**
	 * Muestra el dialogo de estadistica totales de una elección.
	 */
	public void getDialogoEstadisticaTotal() 
	{
	        int cantMasculino = urna.calcularTotalDeVotosMasculinos();
	        int cantFemenino = urna.calcularTotalDeVotosFemeninos();
	        int cantJovenes = urna.totalVotosPorEdad(Edad.JOVEN);
	        int cantAdulto = urna.totalVotosPorEdad( Edad.ADULTO );
	        int cantMayor = urna.totalVotosPorEdad( Edad.MAYOR );
	        int totalVotos = urna.calcularTotalDeVotos();
	        double costoPromedioCampanha = urna.calcularPromedioCostoCampania();
	        DialogoEstadisticaGeneral dialogo = new DialogoEstadisticaGeneral( this, cantMasculino, cantFemenino, cantJovenes, cantAdulto, cantMayor, totalVotos, costoPromedioCampanha );
	        dialogo.setVisible( true );
	
		
	}
	//---------------------------------------------------//
	/**
	 * Reinicia la urna. <br>
	 * <b>post: </b> Se reinició la urna.
	 */
	public void reiniciarUrna()
	{
		urna.reiniciar();
		actualizarInforme();
		
	}
	//---------------------------------------------------//
	/**
	 * Actualiza la interfaz.<br>
	 * <b>post: </b> Se actualizó todos los paneles.
	 */
	private void actualizarInforme()
	{
		candidato1.actualizar( urna.getCandidato1() );
		candidato2.actualizar( urna.getCandidato2() );
		candidato3.actualizar( urna.getCandidato3() );
	
	}
	//---------------------------------------------------//
	/**
	 * Formatear un valor numerico real. 
	 * @param pValor Valor numerico a ser formateado. pValor!=Null && pValor!="":
	 * @return Una cadena con el valor formateado, con puntos y signos.
	 */
	public String formatear(double pValor)
	{
		DecimalFormat df =(DecimalFormat) NumberFormat.getInstance();
		df.applyPattern("###,###.##");
		df.setMinimumFractionDigits(2);
		return df.format(pValor);
	}
	//---------------------------------------------------//
	/**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazUrna principal = new InterfazUrna();
			principal.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
