package com.icetea.bcra.reader.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.junit.Test;

public class NumberUtilsTest {

	@Test
	public void test_ok() {

		BigDecimal r = NumberUtils.toBigDecimal("24,3617", false);
		assertThat(NumberUtils.toString(r), equalTo("24.36"));
	}
}
