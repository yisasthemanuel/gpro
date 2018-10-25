package org.jlobato.gpro.rest;

import java.util.List;

import org.jlobato.gpro.services.IManagerService;
import org.jlobato.gpro.services.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class ManagerController {

	//Servicio. Es la parte de negocio de la aplicacion. Se implementa con una interfaz y se utiliza el patrón business delegate
	//@Autowired
	private IManagerService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List findAll() {
		if (service == null) {
			service = new ManagerService();
		}
		return service.findAll();
	}

/*	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo findOne(@PathVariable("id") Long id) {
		return RestPreconditions.checkFound(service.findOne(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody Foo resource) {
		Preconditions.checkNotNull(resource);
		return service.create(resource);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody Foo resource) {
		Preconditions.checkNotNull(resource);
		RestPreconditions.checkNotNull(service.getById(resource.getId()));
		service.update(resource);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}*/
}
