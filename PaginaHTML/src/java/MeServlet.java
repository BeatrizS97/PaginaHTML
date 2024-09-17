import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// Serve para definir a URL onde este servlet será acessado
@WebServlet("/me.html")
public class MeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        // Serve para definir o tipo de conteúdo da resposta como HTML com codificação UTF-8
        resposta.setContentType("text/html;charset=UTF-8");
        
        // Ele faz uso de um PrintWriter para escrever a resposta HTML
        try (PrintWriter escritor = resposta.getWriter()) {
            escritor.println("<!DOCTYPE html>");
            escritor.println("<html>");
            escritor.println("<head>");
            escritor.println("<title>MeuServlet</title>");
            escritor.println("</head>");
            escritor.println("<body>");
            escritor.println("<h1>RA: 123456</h1>"); // Exibe o RA
            escritor.println("<h2>Nome: Seu Nome</h2>"); // Exibe o nome
            escritor.println("<h2>Idade: 20</h2>"); // Exibe a idade
            escritor.println("</body>");
            escritor.println("</html>");
        }
    }
}