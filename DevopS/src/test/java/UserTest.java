import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	User testUser;
	@BeforeEach
	void setUp() throws Exception {
		testUser = new User("Joey","123456","jyo@gmail.com","English");
	}

	@AfterEach
	void tearDown() throws Exception {
		testUser = null;
	}

	@Test
	void testGetName() {
		String givenName = testUser.getName();
		assertEquals(givenName, "Joey");
	}

	@Test
	void testSetName() {
		testUser.setName("Ozzie");
		assertEquals(testUser.getName(), "Ozzie");
	}

	@Test
	void testGetPassword() {
		String givenPass = testUser.getPassword();
		assertEquals(givenPass, "123456");
	}

	@Test
	void testSetPassword() {
		testUser.setPassword("654321");
		assertEquals(testUser.getPassword(), "654321");
	}

	@Test
	void testGetEmail() {
		String givenEmail = testUser.getEmail();
		assertEquals(givenEmail, "jyo@gmail.com");
	}

	@Test
	void testSetEmail() {
		testUser.setEmail("hello@gmail.com");
		assertEquals(testUser.getEmail(), "hello@gmail.com");
	}

	@Test
	void testGetLanguage() {
		String givenLanguage = testUser.getLanguage();
		assertEquals(givenLanguage, "English");
	}

	@Test
	void testSetLanguage() {
		testUser.setLanguage("Chinese");
		assertEquals(testUser.getLanguage(), "Chinese");
	}

}
