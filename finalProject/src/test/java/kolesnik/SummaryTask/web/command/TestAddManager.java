package kolesnik.SummaryTask.web.command;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import kolesnick.SummaryTask.exception.DBException;
import kolesnick.SummaryTask.web.command.AddManagerCommand;

public class TestAddManager extends Mockito{

    @Test
	public void testExecute() throws IOException, ServletException, DBException {
    	HttpServletRequest request = mock(HttpServletRequest.class);
    	HttpServletResponse response = mock(HttpServletResponse.class);
    	AddManagerCommand addManagerCommand = mock(AddManagerCommand.class);
    	when(addManagerCommand.execute(request, response)).thenReturn("res");
    	assertEquals(addManagerCommand.execute(request, response), "res");
	}

}
