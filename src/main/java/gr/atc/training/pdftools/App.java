package gr.atc.training.pdftools;

public class App {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Expected file and page range");
			System.exit(1);
		}
		String pdfPath = args[0];
		
		System.out.println("args[0]: " + args[0]);
		System.out.println("args[1]: " + args[1]);
		PDFBox pb = new PDFBox();
		
		/*
		String pageRange = args[2];
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
		pb.split(pdfPath, pageStart, pageEnd);
		*/
		/*
		String pdfPath2 = args[1];
		 */
		// pb.merge(pdfPath,pdfPath2);
		
		pb.getText(pdfPath, 4);
	}
}