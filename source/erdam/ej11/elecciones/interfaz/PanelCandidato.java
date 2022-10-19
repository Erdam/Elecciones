package erdam.ej11.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import erdam.ej11.elecciones.mundo.Candidato;

@SuppressWarnings("serial")
/**
 * Panel para mostrar información de un candidato.
 */
public class PanelCandidato extends JPanel implements ActionListener {
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para votar al candidato. 
	 */
	private static final String VOTAR 						= "Votar";
	/**
	 * Comando que visualiza la estadística del candidato
	 */
	private static final String VOTO_POR_RANGO 				= "Votar por rango de edad";
	
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazUrna principal;
	/**
	 * Número del candidato.
	 */
	private int numCandidato;
	/**
	 * Etiqueta nombre del candidato.
	 */
	private JLabel lblNombre;
	/**
	 * Etiqueta edad del candidato.
	 */
	private JLabel lblEdad;
	/**
	 * Etiqueta partido político que pertenece el candidato.
	 */
	private JLabel lblPartidoPolitico;
	/**
	 * Etiqueta costo de campaña del candidato.
	 */
	private JLabel lblCostoCampania;
	/**
	 * Etiqueta cantidad de votos del candidato.
	 */
	private JLabel lblNumeroDeVotos;
	/**
	 * Etiqueta cantidad de votos del candidato.
	 */
	private JLabel lblPorcentajeDeVotos;
	/**
	 * Campo de texto con el nombre del candidato.
	 */
	private JTextField txtNombre;
	/**
	 * Campo de texto con la edad del candidato.
	 */
	private JTextField txtEdad;
	/**
	 * Campo de texto con el partido polítco que pertenece el candidato.
	 */
	private JTextField txtPartidoPolitico;
	/**
	 * Campo de texto con el costo de la campaña.
	 */
	private JTextField txtCostoCampania;
	/**
	 * Campo de texto con el número de votos que el candidato tiene.
	 */
	private JTextField txtNumeroDeVotos;
	/**
	 * Campo de texto con el porcentaje de votos del candidato.
	 */
	private JTextField txtPorcentajeDeVotos;
	/**
	 * Botón para votar.
	 */
	private JButton btnVotar;
	/**
	 * Botón para ver los votos por rango de edad.
	 */
	private JButton btnBotoPorRango;

	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del panel candidato.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal!=null.
	 * @param pNumero Numero de lista del candidato. pNumero > 0 && pNumero < 4.
	 */
	public PanelCandidato(InterfazUrna pPrincipal, int pNumero)
	{
		principal 					= pPrincipal;
		numCandidato 				= pNumero;
		JPanel panelContenedor      = new JPanel();
		JPanel panelInformacion     = new JPanel();
		JPanel panelBotontera       = new JPanel();
		JLabel temp                 = new JLabel();
		
		lblNombre 					= new JLabel("Nombre:");
		lblEdad         			= new JLabel("Edad:");
		lblPartidoPolitico 			= new JLabel("Partido político:");
		lblCostoCampania            = new JLabel("Costo de campaña:");
		lblNumeroDeVotos            = new JLabel("Número de votos:");
		lblNumeroDeVotos.setForeground(Color.red.darker());
		lblPorcentajeDeVotos        = new JLabel("Porcentaje votos:");
		lblPorcentajeDeVotos.setForeground(Color.red.darker());
		
		txtNombre                   = new JTextField(10);
		txtNombre.setEditable(false);
		txtEdad                     = new JTextField(10);
		txtEdad.setEditable(false);
		txtPartidoPolitico          = new JTextField(10);
		txtPartidoPolitico.setEditable(false);
		txtCostoCampania            = new JTextField(10);
		txtCostoCampania.setEditable(false);
		txtNumeroDeVotos            = new JTextField(10);
		txtNumeroDeVotos.setEditable(false);
		txtNumeroDeVotos.setForeground(Color.red.darker());
		txtPorcentajeDeVotos        = new JTextField(10);
		txtPorcentajeDeVotos .setEditable(false);
		txtPorcentajeDeVotos.setForeground(Color.red.darker());
		
		btnBotoPorRango 			= new JButton(VOTO_POR_RANGO);
		btnBotoPorRango.setActionCommand(VOTO_POR_RANGO);
		btnBotoPorRango.addActionListener(this);
		
		btnVotar                   	= new JButton(VOTAR);
		btnVotar.setActionCommand(VOTAR);
		btnVotar.addActionListener(this);
	
		
		 //-----------Dibujar-----------//
		panelContenedor.setLayout(new BorderLayout());
		panelContenedor.setBorder(new TitledBorder("Candidato "+ numCandidato));
		
		temp.setIcon(new ImageIcon("./data/imagen/candidato"+numCandidato+".png"));
		temp.setBorder(new TitledBorder(""));
		temp.setHorizontalAlignment(JLabel.CENTER);
		panelInformacion.setLayout(new GridLayout(8,2,5,5));
		panelBotontera.setLayout(new GridLayout(2,1,5,5));;
		
		panelInformacion.add(new JLabel());
		panelInformacion.add(new JLabel());
		panelInformacion.add(lblNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(lblEdad);
		panelInformacion.add(txtEdad);
		panelInformacion.add(lblPartidoPolitico);
		panelInformacion.add(txtPartidoPolitico);
		panelInformacion.add(lblCostoCampania);
		panelInformacion.add(txtCostoCampania);
		panelInformacion.add(lblNumeroDeVotos);
		panelInformacion.add(txtNumeroDeVotos);
		panelInformacion.add(lblPorcentajeDeVotos);
		panelInformacion.add(txtPorcentajeDeVotos);
		panelInformacion.add(new JLabel());
		panelInformacion.add(new JLabel());
		panelBotontera.add(btnBotoPorRango);
		panelBotontera.add(btnVotar);
		
		panelContenedor.add(temp,BorderLayout.NORTH);
		panelContenedor.add(panelInformacion,BorderLayout.CENTER);
		panelContenedor.add(panelBotontera, BorderLayout.SOUTH);
		add(panelContenedor);
		
	}
	//--------- M É T O D O S ----------//

	// ---------------------------------------------------//
	/**
     * Actualiza el panel con la información del candidato dado por parámetro.
     * @param pCandidato Candidato para mostrar la información. pCandidato != null.
     */
	public void actualizar(Candidato pCandidato)
	{
		
		txtNombre.setText(pCandidato.getNombre()+" "+pCandidato.getApellido());
		txtEdad.setText(Integer.toString(pCandidato.getEdad()));
		txtCostoCampania.setText("$ " +principal.formatear(pCandidato.getCostoDeCampania()));
		txtPartidoPolitico.setText(String.valueOf(pCandidato.getPartidoPolitico()));
		txtNumeroDeVotos.setText(Integer.toString(pCandidato.cantidadVotosTotales()));
		
		 if( pCandidato.cantidadVotosTotales() == 0 )
	        {
	            btnBotoPorRango.setEnabled( false );
	            txtPorcentajeDeVotos.setText( principal.formatear( 0 ) + " %" );
	        }
	        else
	        {
	        	btnBotoPorRango.setEnabled( true );
	        	txtPorcentajeDeVotos.setText( principal.formatear( ( float )pCandidato.cantidadVotosTotales( ) / ( float )principal.getTotalDeVotos() * 100.f ) + " %" );
	        }
	      
		
	}
	// ---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		
		try {
			String command = pEvent.getActionCommand();
			if(VOTO_POR_RANGO.equals(command))
			{
				
				principal.getDialogoEstadisticaCandidato(numCandidato);
			}
			if(VOTAR.equals(command))
			{
				principal.getDialogoVotar(numCandidato);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
     
		
	}

}
