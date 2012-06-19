package foro.index;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import foro.constantes.Constantes;
import foro.modelo.Categoria;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = -1974017208915043322L;
	private List<Categoria> categorias;

	public String execute() {

		setCategorias(Constantes.usuarioDao.obtenerCategorias());

		return SUCCESS;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
