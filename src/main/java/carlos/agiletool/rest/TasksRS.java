package carlos.agiletool.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import carlos.agiletool.entity.Tarea;

@Path("/tareas")
@Produces(MediaType.APPLICATION_JSON)
public class TasksRS {

	@GET
	public List<Tarea> getAllTasks() {

		List<Tarea> tareas = new ArrayList<Tarea>();

		Tarea tarea = new Tarea();
		tarea.setNombre("Pedro");
		tarea.setTarea("PT1200 SII");
		tarea.setPerformance(1.0);
		
		tareas.add(tarea);

		
		return tareas;
	}
}
