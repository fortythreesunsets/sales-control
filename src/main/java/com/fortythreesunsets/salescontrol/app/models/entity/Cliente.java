package com.fortythreesunsets.salescontrol.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{	//es recomendable implementar Serializable en las clases @Entity

	@Id	//PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=12)
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Column(name="creado_en") 	//nombre para el campo en la BD (import.sql)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyy")
	@JsonFormat(pattern="dd/MM/yyy HH:mm:ss")
	private Date creadoEn;
	
	//un cliente, muchas facturas
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)	//orphanRemoval sirve para eliminar registros que no están asociados a ningún cliente	
	@JsonManagedReference	//es la que se quiere mostrar en el documento, en la clase con la que tiene relación, agregar @JsonBackReference
	private List<Factura> facturas;
	
	private String foto;
	
	//Constructor sin parámetros para inicializar la List de facturas
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}

	//Getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	//Método add factura
	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

	//--------------------------------------
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;	
}