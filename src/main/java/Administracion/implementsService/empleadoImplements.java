package Administracion.implementsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Administracion.model.Empleado;
import Administracion.repository.empleadoRepository;
import Administracion.services.empleadoService;

@Service
public class empleadoImplements implements empleadoService{
	
	@Autowired
	private empleadoRepository repo;

	@Override
	public Empleado crearEmpleado(Empleado empleado) {
		return this.repo.save(empleado);
	}

	@Override
	public Optional<Empleado> listarxId(String id) {
		return repo.findById(id);
	}

	@Override
	public List<Empleado> listaempleado() {
		return repo.findAll();
	}

	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}

	@Override
	public Empleado buscarId(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	

}
