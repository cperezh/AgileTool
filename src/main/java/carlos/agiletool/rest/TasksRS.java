package carlos.agiletool.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import carlos.agiletool.dao.DAOTarea;
import carlos.agiletool.entity.Tarea;

@Path("/tareas")
@Produces(MediaType.APPLICATION_JSON)
public class TasksRS {
	
	@EJB
	DAOTarea daoTarea;

	@GET
	public List<Tarea> getAllTasks() {

		List<Tarea> tareas = new ArrayList<Tarea>();
		
		tareas = daoTarea.getAllTasks();
		
		return tareas;
	}
	
	@PUT
	public void modificarTareas(List<Tarea> tareas) {
		for (Tarea tarea:tareas) {
			daoTarea.modificarTarea(tarea);
		}
	}
}
