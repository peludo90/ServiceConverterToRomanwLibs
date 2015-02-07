package co.udea.dlloemp.dao;

import co.udea.dlloemp.entity.ConverterToRoman;


public class ConverterDao {

	public ConverterDao(){
		super();
	}
	
	
	public String convertToRoman(int value){
		ConverterToRoman converter = new ConverterToRoman();
		
		if(converter.isInRange(value)){
			return converter.toRoman(value);
		}else{
			return null;
		}
	}
	
}
