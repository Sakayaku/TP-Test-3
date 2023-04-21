package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void Ex_1() {
		assertEquals("Hello, Bob",Welcome.Welcome("bob"));
		assertEquals("Hello, Sandra",Welcome.Welcome("Sandra"));
		assertEquals("Hello, Véronique",Welcome.Welcome("véronique"));
	}
	
	@Test
	void Ex_2() {
		assertEquals("Hello, my friend",Welcome.Welcome("    "));
		assertEquals("Hello, my friend",Welcome.Welcome(null));
		assertEquals("Hello, my friend",Welcome.Welcome(""));
	}
	
	@Test
	void Ex_3() {
		assertEquals("HELLO, JERRY !",Welcome.Welcome("JERRY"));
		assertEquals("HELLO, FOOL !",Welcome.Welcome("FOOL"));
	}
	
	@Test
	void Ex_4() {
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("amy,bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("amy, bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("Amy,Bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("Amy, Bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("amy, Bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("amy,Bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("Amy, bob"));
		assertEquals("Hello, Amy, Bob",Welcome.Welcome("Amy,bob"));
	}

}
