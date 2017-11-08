package carlos.agiletool.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import carlos.agiletool.entity.Tarea;

@Stateless
public class DAOTarea {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Tarea> getAllTasks(){
		
		return entityManager.createNamedQuery("Tarea.buscarTodas", Tarea.class).getResultList();

	}
	
	public void modificarTarea(Tarea tarea) {
		entityManager.merge(tarea);
		
	}
	
	public void insertarTarea(Tarea tarea) {
		entityManager.persist(tarea);
	}
	
}
