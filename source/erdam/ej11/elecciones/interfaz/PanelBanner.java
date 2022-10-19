package erdam.ej11.elecciones.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel con la imagen del banner.
 */
@SuppressWarnings("serial")
public class PanelBanner extends JPanel {
	//------- A T R I B U T O S -------//
	/**
	 * Representa el contenedor de la imagen.
	 */
	private JLabel contenedor;
	/**
	 * Representa la ruta de la imagen
	 */
	private ImageIcon rutaImg;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel con el banner <br>
	 * <b>post:</b> El panel con el banner quedó iniciado
	 */
	public PanelBanner()
	{
		contenedor = new JLabel();
		rutaImg = new ImageIcon("./data/imagen/Encabezado.png" );
		contenedor.setIcon(rutaImg);
		add(contenedor);
	}


}
