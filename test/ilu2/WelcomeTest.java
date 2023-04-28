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
		assertEquals("HELLO, FOOL !",Welcome.Welcome("  FOOL"));
	}
	
	@Test
	void Ex_4() {
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("amy,bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("amy, bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("Amy,Bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("Amy, Bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("amy, Bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("amy,Bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("Amy, bob"));
		assertEquals("Hello, Amy and Bob",Welcome.Welcome("Amy,bob"));
	}
	
	@Test
	void Ex_5() {
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("amy,bob,jerry"));
		assertEquals("Hello, Amy, Bob, Jerry, Sylvestre, Tom and Cassandra",Welcome.Welcome("amy,bob,jerry,Sylvestre,tom,cassandra"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("amy, bob, Jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy,Bob,Jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy, Bob,  Jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("amy, Bob,Jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("amy,Bob,jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy, bob,jerry"));
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy,bob,Jerry"));
	}
	
	@Test
	void Ex_6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !",Welcome.Welcome("Amy,BOB,jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY !",Welcome.Welcome("           AMY,           bob,jerry"));
		assertEquals("Hello, Amy and Bob. AND HELLO, JERRY !",Welcome.Welcome("Amy,bob,JERRY"));
		assertEquals("Hello, Amy. AND HELLO, BOB AND JERRY !",Welcome.Welcome("Amy,BOB,JERRY"));

	}
	
	@Test
	void Ex_7() {
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy,bob,jerry"));
		assertEquals("Hello, Amy. AND HELLO, BOB AND JERRY !",Welcome.Welcome("Amy, BOB, JERRY"));
		assertEquals("Hello, Amy and Jack. AND HELLO, BOB AND JERRY !",Welcome.Welcome("Amy,Jack, BOB,JERRY"));
		assertEquals("Hello, Jack and Bob. AND HELLO, AMY AND JERRY !",Welcome.Welcome("AMY,Jack,Bob,JERRY"));
		assertEquals("Hello, Amy, Bob, Jerry, Sylvestre, Tom and Cassandra",Welcome.Welcome("amy,bob,jerry,Sylvestre,tom,cassandra"));
		assertEquals("Hello, Amy, Jerry and Cassandra. AND HELLO, BOB, SYLVESTRE, TITI AND TOM !",Welcome.Welcome("amy,BOB,jerry,SYLVESTRE, TITI,TOM,cassandra"));

	}
	
	@Test
	void Ex_8() {
		assertEquals("Hello, Amy, Bob and Jerry",Welcome.Welcome("Amy        ,         bob,jerry"));
		assertEquals("Hello, Amy. AND HELLO, BOB AND JERRY !",Welcome.Welcome("Amy, BOB,          JERRY"));
		assertEquals("Hello, Amy and Jack. AND HELLO, BOB AND JERRY !",Welcome.Welcome("Amy       ,Jack, BOB,JERRY"));
		assertEquals("Hello, Jack and Bob. AND HELLO, AMY AND JERRY !",Welcome.Welcome("AMY,Jack,    Bob,JERRY"));
		assertEquals("Hello, Amy, Bob, Jerry, Sylvestre, Tom and Cassandra",Welcome.Welcome("amy,bob,  jerry  ,Sylvestre,  tom  ,cassandra"));
		assertEquals("Hello, Amy, Jerry and Cassandra. AND HELLO, BOB, SYLVESTRE, TITI AND TOM !",Welcome.Welcome("amy     ,     BOB,jerry,    SYLVESTRE, TITI,  TOM  ,cassandra"));

	}
	
	@Test
	void Ex_9() {
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) !",Welcome.Welcome("bob, JERRY, amy, bob, JERRY, bob"));
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) AND CASSANDRA !",Welcome.Welcome("bob, JERRY, amy, bob, JERRY, bob, CASSANDRA"));
		assertEquals("Hello, Bob (x3). AND HELLO, JERRY AND CASSANDRA !",Welcome.Welcome("bob, JERRY, bob, bob, CASSANDRA"));
		assertEquals("Hello, Amy. AND HELLO, JERRY (x2) !",Welcome.Welcome("JERRY, amy, JERRY"));
	}

}
