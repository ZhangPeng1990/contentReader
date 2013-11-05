package contentReader.test;

public class DocType {

	public static String getType(String fileName){
		String suffix = null;
		String[] temps = fileName.split("\\.");
		
		if(temps == null || temps.length < 2){
			return suffix;
		}else{
			suffix = temps[temps.length - 1];
		}
		
		if(suffix.equals("doc") || suffix.equals("DOC") || suffix.equals("docx") || suffix.equals("DOCX")){
			suffix = "word";
		}else if(suffix.equals("txt") || suffix.equals("TXT")){
			suffix = "txt";
		}else if(suffix.equals("pdf") || suffix.equals("PDF")){
			suffix = "pdf";
		}else{
			suffix = null;
		}
		return suffix;
	}
}
