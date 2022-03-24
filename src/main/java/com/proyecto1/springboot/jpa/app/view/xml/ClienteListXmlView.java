package com.proyecto1.springboot.jpa.app.view.xml;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.proyecto1.springboot.jpa.app.models.entity.Cliente;

@Component("listar.xml")
public class ClienteListXmlView extends MarshallingView {

	//Constructor
	@Autowired
	public ClienteListXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		model.remove("titulo");
		model.remove("page");
		//Para que salgan los de la paginación de la vista html (clientes 1 al 5)***
		//Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
		List<Cliente> clientes = (List<Cliente>) model.get("clientes");
		model.remove("clientes");
		
		//***
		//model.put("clienteList", new ClienteList(clientes.getContent()));
		model.put("clienteList", new ClienteList(clientes));
		
		super.renderMergedOutputModel(model, request, response);
	}
}