/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alin1
 */
public class PeliculasCRUD {
    public static List<Peliculas> getPeliculas() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_peliculasMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM peliculas";
        Query q = manager.createNativeQuery(sql,Peliculas.class); //método para consultas en SQL
        List<Peliculas> peliculasBD =  q.getResultList();

        return peliculasBD;        
        }    
       
       public static int actualizaPelicula(Peliculas miPelicula) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_peliculasMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Peliculas p SET p.titulo = :titulo, p.genero = :genero, p.fecha = :fecha, WHERE p.id = :id";
        Query q = manager.createQuery(sql,Peliculas.class);
        q.setParameter("id", miPelicula.getId());
        q.setParameter("fecha", miPelicula.getFecha());
        q.setParameter("titulo", miPelicula.getTitulo());
        q.setParameter("genero", miPelicula.getGenero());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;      
    }
       
        public static void insertaPelicula(Peliculas pelicula) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_peliculasMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
         manager.getTransaction().begin();
        manager.merge(pelicula);
        manager.getTransaction().commit();
        }
        
        public static int destroyPelicula(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_peliculasMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Peliculas p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
        
      public static Peliculas getPelicula(int id) {  //devuelve un objeto de clase Peliculas
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_peliculasMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Peliculas p WHERE p.id=" + id;
        Query q = manager.createQuery(sql,Peliculas.class); //método para consultas en SQL
        Peliculas miPelicula =  ( Peliculas ) q.getSingleResult(); //para un único registro
        manager.close();
        return  miPelicula;
        } 

    public static int destroyProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
