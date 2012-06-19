package foro.topics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import foro.constantes.Constantes;
import foro.enums.Enums;
import foro.modelo.Categoria;
import foro.modelo.Mensajes;
import foro.modelo.Topic;
import foro.modelo.Usuario;

public class TopicAction extends ActionSupport {

	private static final long serialVersionUID = -6093668296689345971L;
	private List<Topic> topics;
	private String mensaje;
	private Topic topic;
	private List<Categoria> categorias;
	private Usuario usuario;
	private int comienzoPag;

	public String execute() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Integer id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = Constantes.usuarioDao.obtenerCategoria(id);

		// Mostramos los topics de la categoria seleccionada
		topics = Constantes.usuarioDao.obtenerTopics(categoria);

		// obtenemos las categorias de nuevo para que se pueda mostrar en la
		// vista y lo mismo con el usuario
		categorias = Constantes.usuarioDao.obtenerCategorias();
		usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());

		return SUCCESS;
	}

	public String verPost() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Integer id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			topic = Constantes.usuarioDao.obtenerTopic(id);
		} catch (NumberFormatException e) {
			// Si se produce una excepcion es porque hemos entrado desde la
			// parte de ver mensaje, si es asi, se pilla el id de la sesion
			topic = (Topic) request.getSession().getAttribute(
					Enums.topic.toString());
			topic = Constantes.usuarioDao.obtenerTopic(topic.getId());
		}


		// Lo metemos en sesion, ya que en Struts2, para pasar un objeto de una
		// vista a otra vista aunque este en la misma clase hay que meterlo en
		// sesion
		// no vale poner un atributo global, porque lo inicializa de nuevo y lo
		// pone a null
		request.getSession().setAttribute(Enums.topic.toString(), topic);

		Constantes.numPaginas = this.obtenerNumpags();
		try {
			Constantes.paginaActual = Integer.parseInt(request
					.getParameter(Enums.pagActual.toString()));
		} catch (NumberFormatException e) {
			Constantes.paginaActual = 1;
		}
		this.comienzoPag = (Constantes.paginaActual - 1) * 5;
		Constantes.numPaginas = obtenerNumpags();

		// obtenemos las categorias de nuevo para que se pueda mostrar en la
		// vista y lo mismo con el usuario
		categorias = Constantes.usuarioDao.obtenerCategorias();
		usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());

		return SUCCESS;
	}

	public String nuevoMensaje() {
		Map session = ActionContext.getContext().getSession();
		Usuario usuario = (Usuario) session.get(Enums.usuario.toString());

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		topic = (Topic) request.getSession().getAttribute(
				Enums.topic.toString());
		Mensajes mensajeNuevo = new Mensajes(topic, usuario, mensaje,
				new Date());
		// Metemos el mensaje en la bd
		Constantes.usuarioDao.insertarMensaje(mensajeNuevo);
		categorias = Constantes.usuarioDao.obtenerCategorias();
		this.usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());
		
		return SUCCESS;
	}

	

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int obtenerNumpags() {
		BigDecimal big = new BigDecimal((double) topic.getMensajeses().size()
				/ (double) 5);

		big = big.setScale(0, RoundingMode.UP);

		return big.intValue();

	}

	public int getComienzoPag() {
		return comienzoPag;
	}

	public void setPagActual(int comienzoPag) {
		this.comienzoPag = comienzoPag;
	}

}
