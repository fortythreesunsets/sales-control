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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="facturas")
public class Factura implements Serializable{

	@Id	//PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//Indica que es autoincremental
	private Long id;
	
	@NotEmpty
	private String descripcion;
	
	private String observacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="creado_en")
	private Date creadoEn;
	@PrePersist
	public void prePersist() {
		creadoEn = new Date();
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)	//orphanRemoval elimina items que no están asociados a ninguna factura
	@JoinColumn(name="factura_id")	//FK
	private List<ItemFactura> items;
	//Constructor
	public Factura() {
		this.items = new ArrayList<ItemFactura>();
	}
	
	@ManyToOne(fetch=FetchType.LAZY)	//Muchas facturas, un cliente	//LAZY solamente realiza la consulta cuando se le llama
	@JsonBackReference //en la clase con la que tiene relación, agregar @JsonManagedReference
	private Cliente cliente;
	
	//Getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Date getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	@XmlTransient	//omite este atributo en la serialización, no lo incluye en el XML
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	//Método add para ItemFactura
	public void addItemFactura(ItemFactura item) {
		this.items.add(item);
	}
	
	//Método para calcular total
	public Double getTotal() {
		Double total = 0.0;
		int size = items.size();
		for(int i = 0; i < size; i++) {
			total += items.get(i).calcularImporte();
		}
		return total;
	}

	//---------------------------
	private static final long serialVersionUID = 1L;
}
