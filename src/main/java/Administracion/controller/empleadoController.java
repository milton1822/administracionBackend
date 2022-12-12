package Administracion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ResourceCondition;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Administracion.model.Empleado;
import Administracion.services.empleadoService;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
//@CrossOrigin(origins = "http://localhost:4200/")
public class empleadoController {
	
	@Autowired
	private empleadoService servis;
	
	@PostMapping("/crear")
	public ResponseEntity<?>crearempleado(@RequestBody Empleado empleado){
		try {
			Empleado empleadosave = servis.crearEmpleado(empleado);
			return new ResponseEntity<Empleado>(empleadosave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public List<Empleado>listaEmpleado(){
		return servis.listaempleado();
	}
	
	@GetMapping("/empleado/{id}")
	public Empleado getEmpleado(@PathVariable String id) {
		return servis.buscarId(id);
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<Empleado>empleado(@PathVariable String id){
		return servis.listarxId(id);
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminar(@PathVariable String id) {
		servis.delete(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable String id, @RequestBody Empleado emple) {
		Empleado empleado =  servis.buscarId(id);
		empleado.setNombres(emple.getNombres());
		empleado.setApellidos(emple.getApellidos());
		empleado.setTelefono(emple.getTelefono());
		empleado.setDireccion(emple.getDireccion());
		empleado.setOcupacion(emple.getOcupacion());
		Empleado actualizado = servis.crearEmpleado(empleado);
		return ResponseEntity.ok(actualizado);
		
	}
	 
}
