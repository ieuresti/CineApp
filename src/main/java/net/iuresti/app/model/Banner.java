package net.iuresti.app.model;

/**
 * Clase de modelo que representa una imagen del Banner (Carousel) de la pagina principal.
 */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Banners")
public class Banner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String titulo; // Titulo para indicar el atributo title <img src='' title='?' />
	private Date fecha; // Fecha de publicacion del Banner
	private String archivo; // Atributo para guardar el nombre de la imagen
	private String estatus; // Posibles valores: Activo, Inactivo
	
	/**
	 * Constructor sin parametros
	 */
	public Banner() {
		this.fecha = new Date(); // Por default, la fecha del sistema
		this.estatus = "Activo"; // Por default, el banner esta activo
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", estatus="
				+ estatus + "]";
	}

}
