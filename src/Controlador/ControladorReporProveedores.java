package Controlador;


import Modelo.Proveedor;
import Modelo.Servicio;
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:36:13 p.m.
 */
public class ControladorReporProveedores {

    ControladorProveedores ctrlProveedor = new ControladorProveedores();

    /**
     *Constructor vacío
     */
    public ControladorReporProveedores() {
    }

    /**
     *Esta función se encarga de crear el pdf del reporte
     */
    public void crearPDF() {

        Document documentoPDF = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(documentoPDF, new FileOutputStream("reporteProveedores.pdf"));
            documentoPDF.open();

            Font fuente = FontFactory.getFont("Times", 24);
            Paragraph titulo = new Paragraph("Reporte de proveedores", fuente);
            titulo.setAlignment(Element.ALIGN_CENTER);

            documentoPDF.add(titulo);
            documentoPDF.add(Chunk.NEWLINE);//linea vacia
            documentoPDF.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph();
            texto.add("Proveedores con mejores precios");
            documentoPDF.add(texto);
            documentoPDF.add(Chunk.NEWLINE);

            int numColumnas = 6;
            PdfPTable tablaProveedores = new PdfPTable(numColumnas);
            LinkedList<Proveedor> mejoresProveedores = listaMejoresProveedores();
            llenarTabla(tablaProveedores, mejoresProveedores);
            documentoPDF.add(tablaProveedores);

            PdfContentByte contenidoPdf = writer.getDirectContent();
            float ancho = PageSize.LETTER.getWidth() - 100;
            float alto = PageSize.LETTER.getHeight() / 2 - 100;
            PdfTemplate templateBarras = contenidoPdf.createTemplate(ancho, alto);
            Graphics2D grafico2d = new PdfGraphics2D(templateBarras, ancho, alto);
            Rectangle2D rectangulo2d = new Rectangle2D.Double(0, 0, ancho, alto);
            graficaTodosLosProveedores().draw(grafico2d, rectangulo2d);
            grafico2d.dispose();
            contenidoPdf.addTemplate(templateBarras, 20, 50);

            documentoPDF.close();

        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ControladorReporProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorReporProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Llena la tabla que se introducirá al pdf.
     * @param tablaProveedores tabla del pdf
     * @param mejoresProveedores lista de los proveedores con los mejores precios
     */
    public void llenarTabla(PdfPTable tablaProveedores, LinkedList<Proveedor> mejoresProveedores) {
        // addCell() agrega una celda a la tabla, el cambio de fila
        // ocurre automaticamente al llenar la fila
        tablaProveedores.addCell("Servicio");
        tablaProveedores.addCell("Proveedor");
        tablaProveedores.addCell("Telefono");
        tablaProveedores.addCell("Direccion");
        tablaProveedores.addCell("Correo");
        tablaProveedores.addCell("Costo");

        int banquetera = 0;
        int carpa = 1;
        int iluminacion = 2;
        int lugar = 3;
        int musica = 4;

        agregaProveedorATabla(tablaProveedores, mejoresProveedores.get(banquetera), "Banquetera");
        agregaProveedorATabla(tablaProveedores, mejoresProveedores.get(carpa), "Carpa");
        agregaProveedorATabla(tablaProveedores, mejoresProveedores.get(iluminacion), "Iluminacion");
        agregaProveedorATabla(tablaProveedores, mejoresProveedores.get(lugar), "Lugar");
        agregaProveedorATabla(tablaProveedores, mejoresProveedores.get(musica), "Musica");
    }

    /**
     *Agrega cada proveedor a una fila de la tabla
     * @param tabla tabla del pdf
     * @param proveedor provedor que se agregará
     * @param servicio el servicio del proveedor
     */
    public void agregaProveedorATabla(PdfPTable tabla, Proveedor proveedor, String servicio) {

        tabla.addCell(servicio);
        tabla.addCell(proveedor.getNombrePersona());
        tabla.addCell(proveedor.getTelefonoPersona());
        tabla.addCell(proveedor.getDireccionPersona());
        tabla.addCell(proveedor.getCorreoPersona());
        float costo = proveedor.getServicioEspecifico(servicio).getCosto();
        tabla.addCell(Float.toString(costo));

    }

    /**
     *Esta funcion crea una lista con el mejor proveedor de cada servicio.
     * @return LinkedList con los proveedores
     * @throws SQLException
     */
    public LinkedList<Proveedor> listaMejoresProveedores() throws SQLException {

        LinkedList<Proveedor> proveedores = ctrlProveedor.obtenerTodosLosProveedoresConSusServicios();

        Proveedor mejorBanquetera = buscaProveedorMenorPrecio(proveedores, "Banquetera");
        Proveedor mejorCarpa = buscaProveedorMenorPrecio(proveedores, "Carpa");
        Proveedor mejorIluminacion = buscaProveedorMenorPrecio(proveedores, "Iluminacion");
        Proveedor mejorLugar = buscaProveedorMenorPrecio(proveedores, "Lugar");
        Proveedor mejorMusica = buscaProveedorMenorPrecio(proveedores, "Musica");

        LinkedList<Proveedor> mejoresPrecios = new LinkedList();
        mejoresPrecios.add(mejorBanquetera);
        mejoresPrecios.add(mejorCarpa);
        mejoresPrecios.add(mejorIluminacion);
        mejoresPrecios.add(mejorLugar);
        mejoresPrecios.add(mejorMusica);
        return mejoresPrecios;

    }

    /**
     *Busca entre todos los mejores el que tenga el menor precio del servicio seleccionado
     * @param proveedores LinkedList con los proveedores
     * @param servicio servicio del cual se buscará el mejor precio
     * @return el proveedor con el mejor precio del servicio seleccionado
     */
    public Proveedor buscaProveedorMenorPrecio(LinkedList<Proveedor> proveedores, String servicio) {
        Proveedor masBarato = null;

        for (Proveedor proveedor : proveedores) {
            if (proveedor.tieneServicio(servicio)) {
                masBarato = proveedor;
                break;
            }
        }

        Servicio encontrado = masBarato.getServicioEspecifico(servicio);

        for (Proveedor proveedor : proveedores) {
            if (proveedor.tieneServicio(servicio)) {
                Servicio aComparar = proveedor.getServicioEspecifico(servicio);
                if (aComparar.getCosto() < encontrado.getCosto()) {
                    masBarato = proveedor;
                    encontrado = aComparar;
                }
            }
        }

        return masBarato;
    }

    private JFreeChart graficaTodosLosProveedores() throws SQLException {
        

            LinkedList<Proveedor> proveedores = ctrlProveedor.obtenerTodosLosProveedoresConSusServicios();
            DefaultCategoryDataset datosBarras = new DefaultCategoryDataset();

            for (Proveedor proveedor : proveedores) {
                for (Servicio servicio : proveedor.getServiciosQueProvee()) {
                    datosBarras.setValue(servicio.getCosto(),
                            proveedor.getNombrePersona(), servicio.getServNombre());
                }
            }

            JFreeChart graficaBarras = ChartFactory.createBarChart(
                    "Proveedores", //titulo
                    "Servicio", // eje x
                    "Costo", // eje y
                    datosBarras); // datos

            return graficaBarras;
        
        
    }

    /**
     *Crea la gráfica con los precios de un servicio específico
     * @param servicio servicio cuyos precios se graficarán
     * @param proveedores proveedores del servicio
     * @return el modelo de la gráfica
     */
    public JFreeChart graficaServicioEspecífico(String servicio, LinkedList<Proveedor> proveedores) {
        DefaultCategoryDataset datosBarras = new DefaultCategoryDataset();

        for (Proveedor proveedor : proveedores) {
            datosBarras.setValue(proveedor.getServicioEspecifico(servicio).getCosto(),
                    "Proveedor", proveedor.getNombrePersona());
        }

        JFreeChart graficaBarras = ChartFactory.createBarChart(
                "Proveedores de " + servicio, //titulo
                "Proveedor", // eje x
                "Costo", // eje y
                datosBarras); //datos

        return graficaBarras;
    }
}
