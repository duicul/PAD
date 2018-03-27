import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.registry.*;
/**
 * Servlet implementation class Start
 */
@WebServlet(description = "ceva", urlPatterns = { "/Start" })
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String docType ="<!doctype html public>\n";
		String nume=request.getParameter("nume");
		/*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(Hostname.hostname);
            Compute comp = (Compute) registry.lookup(name);
            int t = comp.execute(20);
            //System.out.println(t);
            response.getWriter().println("Value: "+t+"<br>");
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
		/*List<Student>l=new ArrayList<Student>();
        System.out.println(nume);
        try {  
            // Getting the registry 
            Registry registry = LocateRegistry.getRegistry(null); 
       
            // Looking up the registry for the remote object 
            StudentData stub = (StudentData) registry.lookup("Hello"); 
       
            // Calling the remote method using the obtained object 
            l=stub.getStudents(); 
            
            // System.out.println("Remote method invoked"); 
         } catch (Exception e) {
            System.err.println("Client exception: " + e.toString()); 
            e.printStackTrace(); 
         } */
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("<div>Ceau acum "+nume+"</div>");
		//response.getWriter().println(l.get(0).nume);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
