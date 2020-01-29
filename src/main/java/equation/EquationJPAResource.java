package equation;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EquationJPAResource {
	
	@Autowired
	private EquationRepository equationRepository;
	
	
	// retrieveAllUsers
	@CrossOrigin(origins = {"http://calculator-ress-calculator-phi.apps.us-west-1.starter.openshift-online.com/", "http://localhost:31000", "http://localhost:3000", "http://calculator-react-spring.herokuapp.com", "https://calculator-react-spring.herokuapp.com"})
	@GetMapping(path="/postgres/equation/all")
	public List<Equation> retrieveAllEquations() {
		return equationRepository.findAll();
//		return "hello";
	}
	
	@CrossOrigin(origins = {"http://calculator-ress-calculator-phi.apps.us-west-1.starter.openshift-online.com/", "http://localhost:31000", "http://localhost:3000", "http://calculator-react-spring.herokuapp.com", "https://calculator-react-spring.herokuapp.com"})
	@GetMapping(path="/postgres/equation/{id}")
	public Optional<Equation> retrieveEquationById(@PathVariable long id) {
		Optional<Equation> equation = equationRepository.findById(id);
		if(!equation.isPresent()) {
			throw new EquationNotFoundException("id-" + id);
		}
		return equation;
	}
	
	@CrossOrigin(origins = {"http://calculator-ress-calculator-phi.apps.us-west-1.starter.openshift-online.com/", "http://localhost:31000", "http://localhost:3000", "http://calculator-react-spring.herokuapp.com", "https://calculator-react-spring.herokuapp.com"})
	@GetMapping(path="/postgres/equation/count")
	public long equationCount(){
		return equationRepository.count();
	}
	
	@CrossOrigin(origins = {"http://calculator-ress-calculator-phi.apps.us-west-1.starter.openshift-online.com/", "http://localhost:31000", "http://localhost:3000", "http://calculator-react-spring.herokuapp.com", "https://calculator-react-spring.herokuapp.com"})
	@PostMapping("/postgres/equation")
	public ResponseEntity<Object> createUser(@RequestBody Equation equation) {

		equation.setId(equationRepository.count()+1);
		
		Equation savedEquation = equationRepository.save(equation);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedEquation.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@CrossOrigin(origins = {"http://calculator-ress-calculator-phi.apps.us-west-1.starter.openshift-online.com/", "http://localhost:31000", "http://localhost:3000","http://calculator-react-spring.herokuapp.com", "https://calculator-react-spring.herokuapp.com"})
	@DeleteMapping("/postgres/equation/all")
	public void deleteUser(){
		equationRepository.deleteAll();
	}
}

