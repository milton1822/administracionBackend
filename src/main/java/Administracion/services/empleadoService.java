package Administracion.services;

import java.util.List;
import java.util.Optional;

import Administracion.model.Empleado;

public interface empleadoService {
	public Empleado crearEmpleado(Empleado empleado);
	public Optional<Empleado>listarxId(String id);
	public List<Empleado>listaempleado();
	public void delete(String id);
	public Empleado buscarId(String id);
}
