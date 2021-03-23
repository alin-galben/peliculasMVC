/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Peliculas;
import modelo.PeliculasCRUD;

/**
 *
 * @author alin1
 */
@WebServlet(name = "ServletPeliculas", urlPatterns = {"/ServletPeliculas"})
public class ServletPeliculas extends HttpServlet {
private int id;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPeliculas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPeliculas at " + request.getContextPath() + "</h1>");
            if ( op.equals("listar")){
                List<Peliculas> misPeliculas = PeliculasCRUD.getPeliculas();
                request.setAttribute("misPeliculass", misPeliculas);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                
            }
            if ( op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                 request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
            if ( op.equals("insert2")) { //cuando le indicamos que vaya a insertar
                
                    Peliculas miPelicula = new Peliculas();
                    miPelicula.setNombre(request.getParameter("titulo"));
                    miPelicula.setImagen(request.getParameter("genero"));
                    miPelicula.setCategoria(request.getParameter("lanzamiento"));
                    PeliculasCRUD.insertaPelicula(miPelicula);
           
            }
            if ( op.equals("borrar")) { //cuando le indicamos que vaya a borrar
                int id = Integer.parseInt(request.getParameter("id"));
                if ( PeliculasCRUD.destroyProducto(id)>0 ) {
                    out.println("<h1>Registro Borrado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                }
                 
            }
            if ( op.equals("update1")) { //cuando le indicamos que vaya a borrar
                id = Integer.parseInt(request.getParameter("id"));
                Peliculas miPelicula = PeliculasCRUD.getPelicula(id);
                request.setAttribute("miPelicula", miPelicula);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if ( op.equals("update2")) { //cuando le indicamos que vaya a borrar
               String titulo = request.getParameter("titulo");
               String genero = request.getParameter("genero");
               String lanzamiento = request.getParameter("lanzamiento");
               Peliculas miPelicula = new Peliculas(id,titulo,genero,lanzamiento);
                PeliculasCRUD.insertaPelicula(miPelicula);
                String mensaje="Pelicula actualizada";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("miPelicula", miPelicula);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            out.println("</body>");
            out.println("</html>"); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
