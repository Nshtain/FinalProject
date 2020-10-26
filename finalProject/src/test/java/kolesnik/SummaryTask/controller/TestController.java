package kolesnik.SummaryTask.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import kolesnick.SummaryTask.controller.Controller;

public class TestController extends Mockito{

    @Test(expected = NullPointerException.class)
	public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {
        new Controller().doPost(null, null);
	}

    @Test(expected = NullPointerException.class)
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
        new Controller().doGet(null, null);
	}
    
    @Test
    public void TestPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("command")).thenReturn("");

        new Controller().doPost(request, response);

        verify(request, atLeast(1)).getParameter("command"); 
    }

    @Test
    public void TestGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);   
        
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        when(request.getParameter("command")).thenReturn("");
        
        new Controller().doGet(request, response);

        verify(request, atLeast(1)).getParameter("command"); 
    }

}
