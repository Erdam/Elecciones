package erdam.ej11.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import erdam.ej11.elecciones.mundo.Edad;
import erdam.ej11.elecciones.mundo.Genero;
import erdam.ej11.elecciones.mundo.Medios;

@SuppressWarnings("serial")
public class DialogoVotar extends JDialog implements ActionListener{

	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para votar por un candidato.
	 */
	private final static String VOTAR 			= "Votar";
	/**
	 * Comando para cancelar el registro de voto.
	 */
	private final static String CANCELAR 		= "Cancelar";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicaci�n.
	 */
	private InterfazUrna principal;
	/**
	 * N�mero del candidato.
	 */
	private int numeroDeCandidato;
	/**
	 * Etiqueta de g�nero.
	 */
	private JLabel lblGenero;
	/**
	 * Etiqueta rango de edad.
	 */
	private JLabel lblRangoDeEdad;
	/**
	 * Etiqueta de influencia.
	 */
	private JLabel lblInfluencia;
	/**
	 * Bot�n para registrar el voto.
	 */
	private JButton btnVotar;
	/**
	 * Bot�n para cancelar el registro de voto.
	 */
	private JButton btnCancelar;
	/**
	 * Lista de opci�n de g�nero.
	 */
	private JComboBox<String> listaGenero;
	/**
	 * Lista de opci�n de medio de influencia.
	 */
	private JComboBox<String> listaInfluencia;
	/**
	 * Lista de opci�n  Rango de edad. 
	 */
	private JComboBox<String> listaRangoDeEdad;
	
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye el di�logo e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pNumero N�mero del candidato. pNumero > 0 && pNumero < 4.
     */
	public DialogoVotar(InterfazUrna pPrincipal, int pNumero)
	{
		principal 							= pPrincipal;
		numeroDeCandidato 					= pNumero;
		setTitle("Votar");
		setSize(380,245);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		String[] opcionGenero				=	{"Femenino", "Masculino"};
		String[] opcionRangoDeEdad			=	{"J�ven: 18 - 34 a�os", "Adulto: 35 - 54 a�os", "Mayor: 55 o m�s a�os"};
		String[] opcionMedioDeInfluencia	=	{"Televisi�n", "Radio", "Internet"};
		
		listaGenero                         = new JComboBox<String>(opcionGenero);
		listaGenero.setSelectedIndex(0);
		listaGenero.addActionListener(this);
		
		listaInfluencia                     = new JComboBox<String>(opcionMedioDeInfluencia);
		listaInfluencia.setSelectedIndex(0);
		listaInfluencia.addActionListener(this);
		
		listaRangoDeEdad                    = new JComboBox<String>(opcionRangoDeEdad);
		listaRangoDeEdad.setSelectedIndex(0);
		listaRangoDeEdad.addActionListener(this);
		
		lblGenero                           = new JLabel("Seleccione su g�nero:" );
		lblRangoDeEdad                      = new JLabel("Seleccione su rango de edad:" );
		lblInfluencia                       = new JLabel("�Qu� medio de comunicaci�n lo influenci� m�s en su voto?");
		
		btnVotar                            = new JButton(VOTAR);
		btnVotar.setActionCommand(VOTAR);
		btnVotar.addActionListener(this);
		
		btnCancelar                         = new JButton(CANCELAR);
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		
		JPanel panelVotar                   = new JPanel();
		JPanel panelInformacion             = new JPanel();
		JPanel panelBotones                 = new JPanel();
		
		
		add(panelVotar,BorderLayout.CENTER);
	    panelVotar.setLayout( new BorderLayout( ) );
	    panelVotar.setBorder( new CompoundBorder( new EmptyBorder( 3, 5, 3, 5 ), new TitledBorder( "Votar" ) ) );
	    
	    panelInformacion.setLayout( new GridLayout( 6, 1 ) );
	    panelInformacion.add(lblGenero);
	    panelInformacion.add(listaGenero);
	    panelInformacion.add(lblRangoDeEdad);
	    panelInformacion.add(listaRangoDeEdad);
	    panelInformacion.add(lblInfluencia);
	    panelInformacion.add(listaInfluencia);
	    panelBotones.add(btnVotar);
	    panelBotones.add(btnCancelar); 
	    panelVotar.add(panelInformacion,BorderLayout.CENTER);
	     panelVotar.add( panelBotones, BorderLayout.SOUTH );
		setLocationRelativeTo(null);
		
		
	}
	//--------- M � T O D O S ----------//
	/**
     * Registra un voto a un candidato.
     * @param pMedio Medio de influencia del voto.
     * @param pGenero G�nero del votante.
     * @param pRangoEdad Rango de edad del votante.
     */
    public void votar( String pMedio, String pGenero, String pRangoEdad )
    {
    	Genero genero = Genero.MASCULINO;
    	if(pGenero.equals("Femenino"))
    	{
    		genero = Genero.FEMENINO;
    	}
    	
    	Medios medios = Medios.INTERNET;
    	if(pMedio.equals("Televisi�n"))
    	{
    		medios = Medios.TELEVISION;
    	}
    	else if(pMedio.equals("Radio"))
    	{
    		medios = Medios.RADIO;
    	}
    	
    	Edad edad = Edad.JOVEN;
    	if(pRangoEdad.equals("Adulto: 35 - 54 a�os"))
    	{
    		edad = Edad.ADULTO;
    	}
    	else if(pRangoEdad.equals("Mayor: 55 o m�s a�os"))
    	{
    		edad = Edad.MAYOR;
    	}
    	principal.votar(numeroDeCandidato, edad, genero, medios);
    }
	//---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un bot�n. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		try {
			if(command.equals(VOTAR))
			{
				String influencia 	= (String)listaInfluencia.getSelectedItem();
				String genero 		= (String)listaGenero.getSelectedItem();
				String edad   		= (String)listaRangoDeEdad.getSelectedItem();
				votar(influencia, genero, edad);
				dispose();
			}
			if(command.equals(CANCELAR)) {
				dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
