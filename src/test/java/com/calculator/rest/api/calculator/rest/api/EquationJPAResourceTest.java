package com.calculator.rest.api.calculator.rest.api;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import equation.Equation;
import equation.EquationJPAResource;
import equation.EquationRepository;

@ExtendWith(MockitoExtension.class)
public class EquationJPAResourceTest {
	@InjectMocks
	EquationJPAResource equationJPAResource;
	
	@Mock
	EquationRepository equationRepository;
	
	@Test
	public void retrieveAllEquations(){
		Equation equation1 = new Equation((long) 1, "1+1","2");
		Equation equation2 = new Equation((long) 1, "1+2","3");
		Equation equation3 = new Equation((long) 1, "1+3","4");
		List<Equation> equations = new ArrayList<Equation>();
		equations.add(equation1);
		equations.add(equation2);
		equations.add(equation3);
		
		equationRepository.save(equation1);
		equationRepository.save(equation2);
		equationRepository.save(equation3);
		
		when(equationJPAResource.retrieveAllEquations()).thenReturn(equations);
		
		// When
		List<Equation> result = equationJPAResource.retrieveAllEquations();
		
		// Then
		assertThat(result.size()).isEqualTo(3);
		
		
	}
	
	
	
}
