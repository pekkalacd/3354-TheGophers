import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerIDTest {

	@Test
	void emptyID() {
		Customer cust = new Customer();
		assertNotEquals("Here is the test for getID", "", cust.getID());
	}

}