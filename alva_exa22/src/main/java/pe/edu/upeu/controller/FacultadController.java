package pe.edu.upeu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.dao.FacultadDao;
import pe.edu.upeu.daoimpl.FacultadDaoImpl;
import pe.edu.upeu.entity.Facultad;


/**
 * Servlet implementation class EscuelaController
 */
@WebServlet("/facultad")
public class FacultadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacultadDao fdao = new FacultadDaoImpl();
	private Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();
			int op = Integer.parseInt(request.getParameter("opc"));

			switch (op) {
			case 1:
				out.println(gson.toJson(fdao.readAll()));
				break;
			case 2:
				int idc = Integer.parseInt(request.getParameter("id"));
				out.println(gson.toJson(fdao.read(idc)));
				break;
			case 3:
				Facultad fac1 = new Facultad();
				fac1.setNombre(request.getParameter("nombre"));
				out.println(gson.toJson(fdao.create(fac1)));
				break;
			case 4:
				Facultad fac2 = new Facultad();
				fac2.setIdfacultad(Integer.parseInt(request.getParameter("id")));
				fac2.setNombre(request.getParameter("nombre"));
				out.println(gson.toJson(fdao.update(fac2)));
				break;
			case 5:
				out.println(gson.toJson(fdao.delete(Integer.parseInt(request.getParameter("id")))));
				break;
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
