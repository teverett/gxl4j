package com.khubla.gxl4j;

import org.junit.jupiter.api.*;

import com.khubla.gxl4j.generated.*;

public class Test1 {
	@Test
	public void test11() {
		try {
			final GxlType gxlType = new GxlType();
			GXLExporter.export(gxlType, System.out);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
