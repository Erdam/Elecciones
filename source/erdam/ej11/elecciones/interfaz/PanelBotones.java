package erdam.ej11.elecciones.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {
	
	// ------- C O N S T A N T E S -------//
	private static final String ESTADISTICAS 			= "Estadística";
	private static final String VACIAR_URNA 			= "Vaciar urna";
	//------- A T R I B U T O S -------//
	private JButton btnEstadistica;
	private JButton btnVaciarUrna;
	private InterfazUrna principal;
	//----- C O N S T R U C T O R  -----//
	public PanelBotones(InterfazUrna pPrincipal)
	{
		principal = pPrincipal;
		
		JPanel panelContenedor                          = new JPanel();
	
		btnEstadistica                                  = new JButton(ESTADISTICAS);
		btnEstadistica.setPreferredSize( new Dimension( 300, 35 ) );
		btnEstadistica.setActionCommand(ESTADISTICAS);
		btnEstadistica.addActionListener(this);
		
		btnVaciarUrna                                   = new JButton(VACIAR_URNA);
		btnVaciarUrna.setPreferredSize(new Dimension(300, 35));
		btnVaciarUrna.setActionCommand(VACIAR_URNA);
		btnVaciarUrna.addActionListener(this);
		 //-----------Dibujar-----------//
		setBorder(new TitledBorder("Opciones"));
		panelContenedor.setLayout(new GridLayout(1,2,5,5));
		panelContenedor.add(btnEstadistica);
		panelContenedor.add(btnVaciarUrna);
		add(panelContenedor);
		
		
	}
	//--------- M É T O D O S ----------//
	//---------------------------------------------------//

	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */

	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		try {
			if(command.equals(ESTADISTICAS))
			{
				principal.getDialogoEstadisticaTotal();
			}
			if(command.equals(VACIAR_URNA))
			{
				principal.reiniciarUrna();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
