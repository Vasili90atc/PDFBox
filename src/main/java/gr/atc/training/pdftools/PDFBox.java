package gr.atc.training.pdftools;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFBox {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Expected file and page range");
			System.exit(1);
		}
		String pdfPath = args[0];
		String pageRange = args[1];
		System.out.println("pdfPath: " + pdfPath);
		System.out.println("pageRage: " + pageRange);
		
		int pageStart = -1;
		int pageEnd = -1;
		if (pageRange.contains("-")) {
			String[] nums = pageRange.split("-");
			pageStart = Integer.parseInt(nums[0]);
			pageEnd = Integer.parseInt(nums[1]);
		} else {
			pageStart = Integer.parseInt(pageRange);
			pageEnd = Integer.parseInt(pageRange);
		}

		File file = new File(pdfPath);
		PDDocument doc = null;
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
		for (int i=pageStart; i<=pageEnd; i++) {
			new_doc.addPage(doc.getPage(i));
		}
		try {
			new_doc.save(pdfPath + "_" + pageRange + ".pdf");
			new_doc.close();
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}