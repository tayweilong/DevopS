import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterServletTest {
	RegisterServlet servlet;
	HttpServletRequest request;
	HttpServletResponse response;
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegisterServlet() throws ServletException, IOException {
		servlet = new RegisterServlet();
		request = mock(HttpServletRequest.class);
		when(request.getParameter("userName")).thenReturn("audie");
		when(request.getParameter("password")).thenReturn("123456");
		when(request.getParameter("email")).thenReturn("aud@gmail.com");
		when(request.getParameter("language")).thenReturn("English");
		response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);
		new RegisterServlet().doPost(request, response);
		verify(request, atLeast(1)).getParameter("userName");
		assertTrue(stringWriter.toString().contains("Back to Dashboard"));
	}


}
