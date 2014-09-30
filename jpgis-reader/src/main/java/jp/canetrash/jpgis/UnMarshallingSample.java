package jp.canetrash.jpgis;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import jp.canetrash.jpgis.stub.Dataset;


public class UnMarshallingSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		JAXBContext context =
            JAXBContext.newInstance("jp.canetrash.jpgis.stub");
		Unmarshaller unmarshaller =
            context.createUnmarshaller();
	 Dataset dataSet = (Dataset)unmarshaller.unmarshal(new File("src/main/resources/N02-08.xml"));
	}

}
