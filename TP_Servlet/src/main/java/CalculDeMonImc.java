import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double poids = Double.parseDouble(request.getParameter("poids"));
            double taille = Double.parseDouble(request.getParameter("taille"));
            
            Imc imc = new Imc(taille, poids);
            double resultat = imc.calcul();

            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Calcul IMC</title></head><body>");
            out.println("<p>Votre IMC est : " + resultat + "</p>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<p>Veuillez entrer des valeurs valides.</p>");
        }
    }

}
