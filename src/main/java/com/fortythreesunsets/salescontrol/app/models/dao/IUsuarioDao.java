package com.fortythreesunsets.salescontrol.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fortythreesunsets.salescontrol.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	//A través del nombre del método se ejecutará la consulta "select u from Usuario u where u.username=?1"
	public Usuario findByUsername(String username);
}