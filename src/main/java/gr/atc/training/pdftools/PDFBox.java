package gr.atc.training.pdftools;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFBox {

	public PDFBox() {
	}

	public void split(String pdfPath, int pageStart, int pageEnd ) {
		PDDocument doc = new PDDocument();
		File file = new File(pdfPath);	
		try {
			doc = Loader.loadPDF(file);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		if (pageStart < 1 || pageEnd > doc.getNumberOfPages()) {
			System.err.println("Invalid page range");
			System.exit(1);
		}
		
		PDDocument new_doc = new PDDocument();
		for (int i=pageStart; i<=pageEnd; i++) {
			new_doc.addPage(doc.getPage(i));
		}
		try {
			new_doc.save(pdfPath + "_" + Integer.toString(pageStart) + "-" +Integer.toString(pageEnd) + ".pdf");
			new_doc.close();
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void merge(String pdfPath1, String pdfPath2) {
		
	}
}