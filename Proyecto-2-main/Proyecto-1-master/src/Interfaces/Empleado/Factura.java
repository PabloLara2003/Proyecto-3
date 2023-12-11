package Interfaces.Empleado;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Factura {


    public void prueba() {
        // Pide al usuario que ingrese el valor del alquiler
        String precioReserva = JOptionPane.showInputDialog("Ingrese el valor del alquiler:");
        // Pide al usuario que ingrese el valor de los recargos
        String precioRecargo = JOptionPane.showInputDialog("Ingrese el valor de los recargos:");

        // step 1: creation of a document-object
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("Factura_general.pdf"));

            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());   
                  
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);

            g.setColor(new Color(128, 0, 128)); // Morado
            g.drawString("Factura General", 143, 100);
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Precio Reserva: $" + precioReserva, 100, 150);
            g.drawString("Precio Recargo: $" + precioRecargo, 100, 170);
            g.drawString("Firma administrador", 100, 280);
            g.drawString("_______", 100, 350);
            
            // Load the image
            Image firmaImage = loadImage("/imagenes/firma.jpg");
            // Draw the image below the word "Firma"
            g.drawImage(firmaImage, 100, 300, 100, 50, null);

            document.newPage();
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "Se creó el archivo 'Factura_general.pdf' en la carpeta del proyecto");
    }

    private Image loadImage(String path) throws IOException {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl != null) {
            return ImageIO.read(imageUrl);
        }
        throw new IOException("Image not found: " + path);
    }

    public static void main(String[] args) {
        Factura obj = new Factura();
        obj.prueba();
    }
}