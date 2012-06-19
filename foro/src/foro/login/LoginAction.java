package foro.login;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import foro.constantes.Constantes;
import foro.enums.Enums;
import foro.modelo.Categoria;
import foro.modelo.Mensajes;
import foro.modelo.Usuario;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3116824666567746616L;
	private String username;
	private String password;
	private List<Categoria> categorias;
	private Usuario usuario;
	private Map<String, Usuario> session;
	private List<Mensajes> mensajes;

	public String execute() {

		Usuario usuario = Constantes.usuarioDao.obtenerUsuario(this.username,
				this.password);

		if (usuario != null) {

			// Metemos al usuario en la sesi—n
			session = ActionContext.getContext().getSession();
			session.put(Enums.usuario.toString(), usuario);
			this.usuario = usuario;
			Constantes.logueado = true;

			return verCategorias();
		} else {
			addActionError(getText("error.login"));
			verCategorias();
			return ERROR;
		}
	}

	public String verCategorias() {

		// Obtenemos los ultimos 5 mensajes escritos en el foro
		this.mensajes = Constantes.usuarioDao.obtenerMensajesPrincipal();
		Collections.sort(this.mensajes);
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession sesion = request.getSession();

		// Lo obtenemos de nuevo para el caso de que el usuario pulse en el
		// enlace "inicio" ya que en la vista lo obtenemos directamente del
		// parametro usuario y no de la sesion en si
		this.usuario = (Usuario) sesion.getAttribute(Enums.usuario.toString());
		setCategorias(Constantes.usuarioDao.obtenerCategorias());

		return SUCCESS;
	}

	public String desloguear() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession sesion = request.getSession();
		sesion.invalidate();

		Constantes.logueado = false;
		verCategorias();

		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Usuario> getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
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

	public List<Mensajes> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensajes> mensajes) {
		this.mensajes = mensajes;
	}

}
