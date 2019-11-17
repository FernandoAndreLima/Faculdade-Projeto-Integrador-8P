package iel.org.projeto_grid.controller.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratorPDF {
	 
    public static void main(String[] args) {
           // criação do documento
          Document document = new Document();
          try {
              
              PdfWriter.getInstance(document, new FileOutputStream("C:\\PDF_DevMedia.pdf"));
              document.open();
              
              // adicionando um parágrafo no documento
              document.add(new Paragraph("Gerando PDF - Java"));
    }
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          document.close();
      }   
    }