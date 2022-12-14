package com.fortythreesunsets.salescontrol.app.view.csv;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortythreesunsets.salescontrol.app.models.entity.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Component("listar.csv")
public class ClienteCsvView extends AbstractView{
	
	//Constructor
	public ClienteCsvView() {
		setContentType("text/csv");
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"clientes.csv\"");
		response.setContentType(getContentType());
		
		List<Cliente> clientes = (List<Cliente>) model.get("clientes");
		ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] header = {"id", "nombre", "apellido", "email", "creadoEn"};
		beanWriter.writeHeader(header);
		for(Cliente cliente: clientes) {
			beanWriter.write(cliente, header);
		}
		beanWriter.close();
	}
}