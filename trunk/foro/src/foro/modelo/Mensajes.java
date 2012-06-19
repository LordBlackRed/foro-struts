package foro.modelo;

// Generated 12-jun-2012 13:39:35 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

public class Mensajes implements java.io.Serializable, Comparable<Mensajes> {

	private static final long serialVersionUID = -3622296839371038385L;
	private int id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensajes other = (Mensajes) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private Topic topic;
	private Usuario usuario;
	private String mensaje;
	private Date fecha;

	public Mensajes() {
	}

	public Mensajes(int id, Topic topic, Usuario usuario, String mensaje,
			Date fecha) {
		this.id = id;
		this.topic = topic;
		this.usuario = usuario;
		this.mensaje = mensaje;
		this.fecha = fecha;
	}

	public Mensajes(Topic topic, Usuario usuario, String mensaje, Date fecha) {
		this.topic = topic;
		this.usuario = usuario;
		this.mensaje = mensaje;
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int compareTo(Mensajes o) {

		if (this.fecha.before(o.getFecha()))
			return 1;
		else if (this.fecha.after(o.getFecha()))
			return -1;
		else
			return 0;
	}

}
