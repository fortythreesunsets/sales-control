package com.fortythreesunsets.salescontrol.app.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fortythreesunsets.salescontrol.app.models.entity.Cliente;

@XmlRootElement(name="clientes")
public class ClienteList {
	
	@XmlElement(name="cliente")
	public List<Cliente> clientes;

	//Constructor
	public ClienteList(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	//Constructor vacío
	public ClienteList() {
	}

	//Getter
	public List<Cliente> getClientes() {
		return clientes;
	}
}