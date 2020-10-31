package com.khubla.gxl4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.gxl4j.generated.*;

public class Test1 {
	@Test
	public void test11() {
		try {
			final GxlType gxlType = new GxlType();
			/*
			 * marshall
			 */
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GXLMarshaller.exportGraph(gxlType, baos);
			final String marshalled = baos.toString();
			/*
			 * unmarshall
			 */
			final ByteArrayInputStream bais = new ByteArrayInputStream(marshalled.getBytes());
			final GxlType gxlType2 = GXLMarshaller.importGraph(bais);
			assertNotNull(gxlType2);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
