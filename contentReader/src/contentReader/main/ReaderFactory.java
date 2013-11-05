package contentReader.main;

import java.io.File;

import contentReader.enums.Type;
import contentReader.main.impl.DocReader;
import contentReader.main.impl.PdfReader;
import contentReader.main.impl.TxtReader;

public class ReaderFactory {

	public static Reader initReader(File file){
		Reader reader = null;
		Type type = getType(file.getName());
		
		switch(type){
			case PDF : reader = new PdfReader(file);
			break;
			
			case TXT : reader = new TxtReader(file);
			break;
			
			case DOC : reader = new DocReader(file);
			break;
		}
		
		return reader;
	}
	
	public static Type getType(String fileName){
		String suffix = null;
		String[] temps = fileName.split("\\.");
		
		if(temps == null || temps.length < 2){
			return null;
		}else{
			suffix = temps[temps.length - 1];
		}
		
		if(suffix.equals("doc") || suffix.equals("DOC") || suffix.equals("docx") || suffix.equals("DOCX")){
			return Type.DOC;
		}else if(suffix.equals("txt") || suffix.equals("TXT")){
			return Type.TXT;
		}else if(suffix.equals("pdf") || suffix.equals("PDF")){
			return Type.PDF;
		}else{
			return null;
		}
	}
	
}
