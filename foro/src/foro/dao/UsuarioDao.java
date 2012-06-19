package foro.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import foro.modelo.Categoria;
import foro.modelo.Mensajes;
import foro.modelo.Topic;
import foro.modelo.Usuario;
import foro.util.UtilHibernate;

public class UsuarioDao {

	public List<Categoria> obtenerCategorias() {

		Session ses = UtilHibernate.getSessionFactory().openSession();

		Criteria cr = ses.createCriteria(Categoria.class);
		List<Categoria> categorias = cr.list();

		return categorias;

	}

	public Categoria obtenerCategoria(Integer id) {

		Session ses = UtilHibernate.getSessionFactory().openSession();
		Criteria cr = ses.createCriteria(Categoria.class);
		cr.add(Restrictions.idEq(id));

		Categoria categoria = (Categoria) cr.uniqueResult();

		return categoria;
	}

	public List<Topic> obtenerTopics(Categoria categoria) {

		Session ses = UtilHibernate.getSessionFactory().openSession();
		Criteria cr = ses.createCriteria(Topic.class);
		cr.add(Restrictions.eq("categoria", categoria));

		List<Topic> topics = cr.list();

		return topics;
	}

	public Topic obtenerTopic(Integer id) {

		Session ses = UtilHibernate.getSessionFactory().openSession();
		Criteria cr = ses.createCriteria(Topic.class);
		cr.add(Restrictions.idEq(id));

		Topic topic = (Topic) cr.uniqueResult();

		return topic;
	}

	public Usuario obtenerUsuario(String username, String password) {

		Session ses = UtilHibernate.getSessionFactory().openSession();
		Criteria cr = ses.createCriteria(Usuario.class);
		cr.add(Restrictions.eq("nick", username));
		cr.add(Restrictions.eq("password", password));

		Usuario usuario = (Usuario) cr.uniqueResult();

		return usuario;
	}

	public void insertarMensaje(Mensajes mensaje) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = UtilHibernate.getSessionFactory().openSession();

			tx = ses.beginTransaction();

			ses.persist(mensaje);
			tx.commit();
			ses.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			if (ses != null)
				ses.close();
		}
	}

	public List<Mensajes> obtenerMensajesPrincipal() {

		Session ses = UtilHibernate.getSessionFactory().openSession();
		Criteria cr = ses.createCriteria(Mensajes.class);

		List<Mensajes> mensajes = (List<Mensajes>) cr.list();

		return mensajes;
	}
}
