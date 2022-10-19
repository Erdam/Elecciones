package erdam.ej11.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
/**
 * Diálogo para mostrar las estadísticas de un candidato.
 */
public class DialogoEstadisticaGeneral extends JDialog{

	//------- A T R I B U T O S -------//
    /**
     * Venta principal de la aplicación.
     */
	private InterfazUrna principal;
	/**
     * Etiqueta total votos en urna.
     */
    private JLabel lblTotalVotos;

    /**
     * Etiqueta Promedio costo de campaña.
     */
    private JLabel lblPromedioCostoCampanha;

    /**
     * Campo de texto total votos en urna.
     */
    private JTextField txtTotalVotos;

    /**
     * Campo de texto Promedio costo de campaña.
     */
    private JTextField txtPromedioCostoCampanha;

    /**
     * Dataset de los votantes por género.
     */
    private DefaultCategoryDataset datosGenero;

    /**
     * Dataset de los votantes por rango de edad.
     */
    private DefaultCategoryDataset datosRangoEdad;

	//----- C O N S T R U C T O R  -----//
    /**
     * Construye el diálogo e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pVotosMasculinos Cantidad de votos de género masculino.
     * @param pVotosFemeninos Cantidad de votos de género femenino.
     * @param pVotosJovenes Cantidad de votos de personas en el rango jóvenes.
     * @param pVotosAdultos Cantidad de votos de personas en el rango edad media.
     * @param pVotosMayores Cantidad de votos de personas en el rango edad adultos mayores.
     * @param pTotalVotos Cantidad total de votos.
     * @param pCostoPromedioCampanha Cantidad promedio por campaña.
     */
	public DialogoEstadisticaGeneral(InterfazUrna pPrincipal, int pVotosMasculinos, int pVotosFemeninos, int pVotosJovenes, int pVotosAdultos, int pVotosMayores, int pTotalVotos, double pCostoPromedioCampanha)
	{
		principal = pPrincipal;
		setTitle( "Estadísticas" );
        setSize( 650, 400 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        JPanel panelEstadisticas = new JPanel( );
        panelEstadisticas.setBorder( new TitledBorder( "Estadísticas generales" ) );
        panelEstadisticas.setLayout( new BorderLayout( ) );
        add( panelEstadisticas );

        JPanel auxCentro = new JPanel( );
        auxCentro.setLayout( new GridLayout( 1, 3 ) );
        panelEstadisticas.add( auxCentro, BorderLayout.CENTER );

        datosGenero = new DefaultCategoryDataset( );
        JFreeChart graficoGenero = crearGrafico( "Votos por género", "Género", datosGenero );
        ChartPanel auxGenero = new ChartPanel( graficoGenero );
        auxGenero.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        auxGenero.setPreferredSize( new Dimension( 200, 200 ) );
        auxCentro.add( auxGenero );
        datosGenero.setValue( pVotosMasculinos, "Masculino", " " );
        datosGenero.setValue( pVotosFemeninos, "Femenino", " " );

        datosRangoEdad = new DefaultCategoryDataset( );
        JFreeChart graficoRangoEdad = crearGrafico( "Votos por rango de edad", "Rango de edad", datosRangoEdad );
        ChartPanel auxRangoEdad = new ChartPanel( graficoRangoEdad );
        auxRangoEdad.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        auxRangoEdad.setPreferredSize( new Dimension( 200, 200 ) );
        auxCentro.add( auxRangoEdad );
        datosRangoEdad.setValue( pVotosJovenes, "18 - 34 años", "" );
        datosRangoEdad.setValue( pVotosAdultos, "35 - 54 años", "" );
        datosRangoEdad.setValue( pVotosMayores, "55 ó más años", "" );

        JPanel auxSur = new JPanel( );
        auxSur.setLayout( new GridLayout( 2, 2 ) );
        panelEstadisticas.add( auxSur, BorderLayout.SOUTH );

        // Etiqueta total votos
        lblTotalVotos = new JLabel( "Total votos:" );
        lblTotalVotos.setForeground( Color.BLUE.darker( ) );
        lblTotalVotos.setFont( new Font( "Times New Roman", Font.BOLD, 19 ) );
        auxSur.add( lblTotalVotos );

        txtTotalVotos = new JTextField( "" + pTotalVotos );
        txtTotalVotos.setEditable( false );
        txtTotalVotos.setForeground( Color.BLUE.darker( ) );
        txtTotalVotos.setFont( new Font( "Times New Roman", Font.BOLD, 19 ) );
        auxSur.add( txtTotalVotos );

        // Etiqueta total costo de campaña
        lblPromedioCostoCampanha = new JLabel( "Costo promedio por campaña:" );
        lblPromedioCostoCampanha.setForeground( Color.BLUE.darker( ) );
        lblPromedioCostoCampanha.setFont( new Font( "Times New Roman", Font.BOLD, 19 ) );
        auxSur.add( lblPromedioCostoCampanha );

        txtPromedioCostoCampanha = new JTextField( "$ " + principal.formatear( pCostoPromedioCampanha ) );
        txtPromedioCostoCampanha.setEditable( false );
        txtPromedioCostoCampanha.setForeground( Color.BLUE.darker( ) );
        txtPromedioCostoCampanha.setFont( new Font( "Times New Roman", Font.BOLD, 19 ) );
        auxSur.add( txtPromedioCostoCampanha );

        setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
	}
	//--------- M É T O D O S ----------//
	 /**
     * Crea y configura los atributos de la gráfica en barras.
     * @param pTitulo Título de la gráfica.
     * @param pEje Título del eje horizontal.
     * @return pDatos Datos que se dibujan en la gráfica.
     */
    private static JFreeChart crearGrafico( String pTitulo, String pEje, DefaultCategoryDataset pDatos )
    {

        JFreeChart chart = ChartFactory.createBarChart( pTitulo, pEje, "Votos", pDatos, PlotOrientation.VERTICAL, true, true, false );

        chart.setBackgroundPaint( Color.white );

        CategoryPlot plot = chart.getCategoryPlot( );
        plot.setBackgroundPaint( Color.lightGray );
        plot.setDomainGridlinePaint( Color.white );
        plot.setRangeGridlinePaint( Color.white );

        NumberAxis rangeAxis = ( NumberAxis )plot.getRangeAxis( );
        rangeAxis.setStandardTickUnits( NumberAxis.createIntegerTickUnits( ) );

        BarRenderer renderer = ( BarRenderer )plot.getRenderer( );
        renderer.setDrawBarOutline( false );

        CategoryAxis domainAxis = plot.getDomainAxis( );
        domainAxis.setCategoryLabelPositions( CategoryLabelPositions.createUpRotationLabelPositions( Math.PI /6.0 ) );
        return chart;
    }
	//---------------------------------------------------//
}
