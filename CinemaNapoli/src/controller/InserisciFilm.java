package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Film;
import model.Genere;

import static util.GestisciDatabase.*;

@WebServlet(name="inserisciFilm", urlPatterns={"/InserisciFilm"})
@MultipartConfig
public class InserisciFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Film>listaFilm;       
    //---
    public InserisciFilm() {
        super();
    }
	//---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("titolo") != null) {
			Film f = new Film();
			Genere g = cercaGenere(Long.parseLong(request.getParameter("genere")));
			f.setTitolo(request.getParameter("titolo"));
			f.setGenere(g);

			// -----------------------------------------------------------------------
			final String path = "C:\\imgMultisalaMedea\\Progetto-Cinema\\CinemaNapoli\\WebContent\\caroImg";
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
			//f.setLocandina(path + "\\" + fileName);
			f.setLocandina("/CinemaNapoli/caroImg/"+fileName);
			f.setTrama(request.getParameter("trama"));
			f.setDurata(Integer.parseInt(request.getParameter("durata")));
			f.setAnnouscita(Integer.parseInt(request.getParameter("annouscita")));
			List<Film> listaFilm = leggiFilm();
			boolean possoinserire = true;
			for (Film film : listaFilm) {
				if (film.getTitolo().equalsIgnoreCase(f.getTitolo()) && film.getAnnouscita() == (f.getAnnouscita())) {
					System.out.println("Il film già c'è");
					possoinserire = false;
					break;
				}
			}
			if (possoinserire) {
				aggiungiFilm(f);
			}
		}
		request.setAttribute("controllo", 3);
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
		//doGet(request, response);
	}
	//---
	private String getFileName(final Part part) {
		
		System.out.println(part.getHeader("content-disposition"));
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
}

