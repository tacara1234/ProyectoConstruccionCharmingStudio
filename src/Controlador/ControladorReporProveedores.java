package Controlador;

import Controlador.AdministraReportes;
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
import java.awt.Color;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:36:13 p.m.
 */
public class ControladorReporProveedores implements AdministraReportes {

    public ControladorReporProveedores() {

    }
    @Override
    public Object generaReportes() {
        return null;
    }

    /**
     *
     * @param vector
     * @return 
     */
    @Override
    public boolean exportaReportes(Object vector) {
        return false;
    }

    public void generaPDF() {
        
        Document documentoPDF = new Document() ; 
        
        try {
            
            LinkedList<Proveedor> mejoresProveedores=mejoresPrecios();
            
            PdfWriter writer= PdfWriter.getInstance(documentoPDF, new FileOutputStream("tablas.pdf"));
            documentoPDF.open();
            // Este codigo genera una tabla de 6 columnas
            PdfPTable table = new PdfPTable(6);                
            
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Servicio");
            table.addCell("Proveedor");
            table.addCell("Telefono");
            table.addCell("Direccion");
            table.addCell("Correo");
            table.addCell("Costo");
            
            agregaProveedorATabla(table,mejoresProveedores.get(0),"Banquetera");
            agregaProveedorATabla(table,mejoresProveedores.get(1),"Carpa");
            agregaProveedorATabla(table,mejoresProveedores.get(2),"Iluminacion");
            agregaProveedorATabla(table,mejoresProveedores.get(3),"Lugar");
            agregaProveedorATabla(table,mejoresProveedores.get(4),"Musica");
            
            // Agregamos la tabla al documento   
            Font fuente=FontFactory.getFont("Times", 24);
            Paragraph titulo = new Paragraph("Reporte de proveedores",fuente);
            
            titulo.setAlignment(Element.ALIGN_CENTER);
            documentoPDF.add(titulo);
            documentoPDF.add( Chunk.NEWLINE );
            documentoPDF.add( Chunk.NEWLINE );
            
            documentoPDF.add(table);
            
            /////////////////////////////////////FALTA refac.....
            PdfContentByte cb = writer.getDirectContent();
        float width = PageSize.LETTER.getWidth()-100;
        float height = PageSize.LETTER.getHeight() / 2-100;
        // Pie chart
        PdfTemplate bar = cb.createTemplate(width, height);
        Graphics2D g2d1 = new PdfGraphics2D(bar, width, height);
        Rectangle2D r2d1 = new Rectangle2D.Double(0, 0, width, height);
        getBarChart("Lugar").draw(g2d1, r2d1);
        g2d1.dispose();
        cb.addTemplate(bar, 20,50);
            
            documentoPDF.close();
            
        } catch ( DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ControladorReporProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorReporProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void agregaProveedorATabla(PdfPTable tabla, Proveedor proveedor, String servicio){
        tabla.addCell(servicio);
            tabla.addCell(proveedor.getNombrePersona());
            tabla.addCell(proveedor.getTelefonoPersona());
            tabla.addCell(proveedor.getDireccionPersona());
            tabla.addCell(proveedor.getCorreoPersona());
            float costo=proveedor.getServicioEspecifico(servicio).getCosto();
            tabla.addCell(Float.toString(costo));
    }

    
    public LinkedList<Proveedor> mejoresPrecios() throws SQLException{
        ControladorProveedores ctrlProv=new ControladorProveedores();
        LinkedList<Proveedor> proveedores=ctrlProv.obtenerTodosLosProveedoresConSusServicios();
        Proveedor mejorBanquetera=buscaMenorPrecio(proveedores,"Banquetera");
            Proveedor mejorCarpa=buscaMenorPrecio(proveedores,"Carpa");
            Proveedor mejorIluminacion=buscaMenorPrecio(proveedores,"Iluminacion");
            Proveedor mejorLugar=buscaMenorPrecio(proveedores,"Lugar");
            Proveedor mejorMusica=buscaMenorPrecio(proveedores,"Musica");
            
            LinkedList<Proveedor> mejoresPrecios=new LinkedList();
            mejoresPrecios.add(mejorBanquetera);
            mejoresPrecios.add(mejorCarpa);
            mejoresPrecios.add(mejorIluminacion);
            mejoresPrecios.add(mejorLugar);
            mejoresPrecios.add(mejorMusica);
            return mejoresPrecios;
            
    }
    
    public Proveedor buscaMenorPrecio(LinkedList<Proveedor> proveedores, String servicio){
        Proveedor masBarato=null;
       
         for(Proveedor proveedor:proveedores){
             if(proveedor.tieneServicio(servicio)){
                 masBarato=proveedor;
                 break;
             }
         }
        Servicio encontrado=masBarato.getServicioEspecifico(servicio);
        
        for(Proveedor proveedor:proveedores){
            if(proveedor.tieneServicio(servicio)){
                Servicio temp=proveedor.getServicioEspecifico(servicio);
                System.out.println(temp.getCosto());
                System.out.println(encontrado.getCosto());
                if(temp.getCosto()<encontrado.getCosto()){
                    masBarato=proveedor;
                    encontrado=temp;
                }
            
            }
        }
        
        return masBarato;
    }

    private JFreeChart getBarChart(String servicioSeleccionado) {
        try {
            ControladorProveedores ctrlProv=new ControladorProveedores();  
            LinkedList<Proveedor> proveedores =ctrlProv.obtenerTodosLosProveedoresConSusServicios();
                DefaultCategoryDataset bardataset = new DefaultCategoryDataset();


                for (Proveedor proveedor : proveedores) {
                   for(Servicio servicio:proveedor.getServiciosQueProvee()){
                    bardataset.setValue(servicio.getCosto(),
                            proveedor.getNombrePersona(),servicio.getServNombre());
                    
                   }
                }

                JFreeChart barchart = ChartFactory.createBarChart(
                        "Proveedores", //Title
                        "Proveedor", // X-axis Label
                        "Costo", // Y-axis Label
                        bardataset, // Dataset
                        PlotOrientation.VERTICAL, //Plot orientation
                        false, // Show legend
                        true, // Use tooltips
                        false // Generate URLs
                        );
                barchart.getTitle().setPaint(Color.BLUE);    // Set the colour of the title
                barchart.setBackgroundPaint(Color.WHITE);    // Set the background colour of the chart
                CategoryPlot cp = barchart.getCategoryPlot();  // Get the Plot object for a bar graph
                cp.setBackgroundPaint(Color.WHITE);       // Set the plot background colour
                cp.setRangeGridlinePaint(Color.RED);   
                return barchart;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorReporProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
    
}
