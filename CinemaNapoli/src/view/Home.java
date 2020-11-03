package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/header.jsp").include(request, response);
		//jsp form di registrazione (cambiare il nome)
		//request.getServletContext().getRequestDispatcher("/formRegistrazione.jsp").include(request, response);
		request.getServletContext().getNamedDispatcher("registrazione").include(request, response);
		//jsp form di login (cambiare il nome)
		//request.getServletContext().getRequestDispatcher("/formLogin.jsp").include(request, response);
		request.getServletContext().getNamedDispatcher("login").include(request, response);
		//jsp con le immagini della homepage
		//request.getServletContext().getRequestDispatcher("/caroselloImmagini.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/footer.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
