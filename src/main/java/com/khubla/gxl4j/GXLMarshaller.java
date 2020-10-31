package com.khubla.gxl4j;

import java.io.*;

import javax.xml.bind.*;

import com.khubla.gxl4j.generated.*;

public class GXLMarshaller {
	private final static String PACKAGE = "com.khubla.gxl4j.generated";

	public static void exportGraph(GxlType gxlType, OutputStream outputStream) throws IOException, JAXBException {
		if ((null != gxlType) && (null != outputStream)) {
			final JAXBContext jc = JAXBContext.newInstance(PACKAGE);
			final Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			/*
			 * marshal
			 */
			final ObjectFactory objectFactory = new ObjectFactory();
			final JAXBElement<GxlType> je = objectFactory.createGxl(gxlType);
			marshaller.marshal(je, outputStream);
		}
	}

	public static GxlType importGraph(InputStream inputStream) throws IOException, JAXBException {
		if (null != inputStream) {
			final JAXBContext jc = JAXBContext.newInstance(PACKAGE);
			final Unmarshaller unmarshaller = jc.createUnmarshaller();
			@SuppressWarnings("unchecked")
			final JAXBElement<GxlType> je = (JAXBElement<GxlType>) unmarshaller.unmarshal(inputStream);
			return je.getValue();
		} else {
			return null;
		}
	}
}
