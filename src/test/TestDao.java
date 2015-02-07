package test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.udea.dlloemp.dao.ConverterDao;
import co.udea.dlloemp.entity.ConverterToRoman;

public class TestDao {

	@Test
	public void testClass() {
		ConverterToRoman converter = new ConverterToRoman();
		
		assertEquals("M", converter.toRoman(1000));
		
	}
	
	@Test
	public void test() {
		ConverterDao converterDao = new ConverterDao();
		
		assertEquals("M", converterDao.convertToRoman(1000));
		
	}
	


}
