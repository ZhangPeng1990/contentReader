package contentReader.test;

import java.io.File;

import org.junit.Test;

import contentReader.main.Reader;
import contentReader.main.ReaderFactory;

public class TestReader {

	@Test
	public void test(){
		File file = new File("F:\\test\\test.pdf");
		Reader r = ReaderFactory.initReader(file);
		System.out.println(r);
	}
	
}
