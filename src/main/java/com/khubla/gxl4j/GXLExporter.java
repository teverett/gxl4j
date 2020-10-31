package com.khubla.gxl4j;

import java.io.*;

import javax.xml.bind.*;

import com.khubla.gxl4j.generated.*;

public class GXLExporter {
	public static void export(GxlType gxlType, OutputStream outputStream) throws IOException, JAXBException {
		if (null != gxlType) {
			final JAXBContext jc = JAXBContext.newInstance("com.khubla.gxl4j.generated");
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
}
