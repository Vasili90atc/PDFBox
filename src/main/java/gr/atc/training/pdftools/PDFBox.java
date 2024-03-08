package gr.atc.training.pdftools;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFBox {

	public PDFBox() {
	}

	public void split(String pdfPath, int pageStart, int pageEnd) {
		PDDocument doc = null;
		File file = new File(pdfPath);
		try {
			doc = Loader.loadPDF(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pageStart < 1 || pageEnd > doc.getNumberOfPages()) {
			System.err.println("Invalid page range");
			System.exit(1);
		}
		PDDocument new_doc = new PDDocument();
		for (int i = pageStart; i <= pageEnd; i++) {
			new_doc.addPage(doc.getPage(i));
		}
		try {
			new_doc.save(pdfPath.split("\\.")[0] + "_" + Integer.toString(pageStart) + "-" + Integer.toString(pageEnd)
					+ ".pdf");
			new_doc.close();
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void merge(String pdfPath1, String pdfPath2) {
		PDDocument doc_enwsi = new PDDocument();
		PDDocument doc1 = null;
		PDDocument doc2 = null;
		File file1 = new File(pdfPath1);
		File file2 = new File(pdfPath2);
		try {
			doc1 = Loader.loadPDF(file1);
			doc2 = Loader.loadPDF(file2);

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		for (int j = 0; j < doc1.getNumberOfPages(); j++) {
			doc_enwsi.addPage(doc1.getPage(j));
		}
		for (int j = 0; j < doc2.getNumberOfPages(); j++) {
			doc_enwsi.addPage(doc2.getPage(j));
		}
		try {
			doc_enwsi.save(pdfPath1.split("\\.")[0] + "_" + pdfPath2.split("\\.")[0] + ".pdf");
			doc_enwsi.close();
			doc1.close();
			doc2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}