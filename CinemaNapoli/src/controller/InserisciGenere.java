package controller;

import static util.GestisciDatabase.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Genere;
import static util.Controlli.*;

@WebServlet(name = "inserisciGenere", urlPatterns = { "/InserisciGenere" })
@MultipartConfig
public class InserisciGenere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserisciGenere() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Genere g = new Genere();
		if (controlloInserimento(request.getParameter("nomeGenere"))) {
			g.setNome(request.getParameter("nomeGenere"));

			// -----------------------------------------------------------------------
			final String path = "D:\\Git-Repo\\Progetto-Cinema\\CinemaNapoli\\WebContent\\caroImg";
			final Part filePart = request.getPart("file");
			System.out.println(filePart);
			final String fileName = getFileName(filePart);
			System.out.println(fileName);

			try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
					InputStream fileContent = filePart.getInputStream();) {

				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = fileContent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// -----------------------------------------------------------------------
			// g.setImg(request.getParameter("file").equals("") ? null :
			// request.getParameter("file"));
			g.setImg("/CinemaNapoli/caroImg/" + fileName);

			try {
				aggiungiGenere(g);
			} catch (RollbackException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("controllo", 3);
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}

	// ---
	private String getFileName(final Part part) {

		System.out.println(part.getHeader("content-disposition"));
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
