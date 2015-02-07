package co.udea.dlloemp.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.udea.dlloemp.dao.ConverterDao;
import co.udea.dlloemp.rest.NumToRomanConverter;




@Path(value="/convertertoroman")
@WebService(endpointInterface="co.udea.dlloemp.rest.NumToRomanConverter")
public class NumToRomanConverterRestService implements NumToRomanConverter{
	
	private ConverterDao converterDao;
	
	public NumToRomanConverterRestService(){
		converterDao = new ConverterDao();
	}

	@GET
	@Path(value="/numbertoconvert/{numberValue}")
	@Produces(value ={MediaType.APPLICATION_JSON})
	@Override
	public String convertToRoman(@PathParam(value="numberValue") int value) {
		// TODO Auto-generated method stub
		return converterDao.convertToRoman(value);
	}

}
