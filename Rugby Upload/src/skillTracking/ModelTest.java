package skillTracking;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

//JUnit tests created to test the Model data lists after data generation

class ModelTest {

	// Test to confirm data generation or serialisation had populated the Member ArrayList
	
	@Test
	void memberListPopulation() {
		
		Model model = new Model();																									// Set variable to instance of Model for data retrieval 
	
		int listSize = 24;																											// Test variable set to expected output
		
		System.out.print(model.allMembers.size());																					// Console output of list size
		
		assertEquals(listSize,model.allMembers.size());																				// Assert that ArrayList size is 24
		
	}
	
	// Test to confirm data generation or serialisation had populated the squad ArrayList
	
	@Test
	void squadListPopulation() {
		
		Model model = new Model();																									// Set variable to instance of Model for data retrieval 
	
		int listSize = 3;																											// Test variable set to expected output
		
		System.out.print(model.allSquads.size());																					// Console output of list size
		
		assertEquals(listSize,model.allSquads.size());																				// Assert that ArrayList size is 24
		
	}
	
	// Test to confirm data generation or serialisation had populated the coach ArrayList
	
	@Test
	void coachListPopulation() {
		
		Model model = new Model();																									// Set variable to instance of Model for data retrieval 
	
		int listSize = 3;																											// Test variable set to expected output
		
		System.out.print(model.allCoaches.size());																					// Console output of list size
		
		assertEquals(listSize,model.allCoaches.size());																				// Assert that ArrayList size is 3
		
	}
	
	// Test to confirm data generation or serialisation had populated the login account HashMap
	
	@Test
	void accountListPopulation() {
		
		Model model = new Model();																									// Set variable to instance of Model for data retrieval 
	
		int listSize = 3;																											// Test variable set to expected output
		
		System.out.print(model.loginDetails.size());																				// Console output of list size
		
		assertEquals(listSize,model.loginDetails.size());																			// Assert that HashMap size is 3
		
	}
	
	

}
