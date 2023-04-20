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
	}

}
