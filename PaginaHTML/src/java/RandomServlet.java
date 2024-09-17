import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/random.html")
public class RandomServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        // Serve para definir o tipo de conteúdo da resposta como HTML com codificação UTF-8
        resposta.setContentType("text/html;charset=UTF-8");
        
        // Utiliza um PrintWriter para escrever a resposta HTML
        try (PrintWriter escritor = resposta.getWriter()) {
            // É um conjunto para armazenar números únicos
            Set<Integer> numeros = new HashSet<>();
            // Tem como objetivo criar um objeto Random para gerar números aleatórios
            Random aleatorio = new Random();
            
            // Gera 6 números aleatórios únicos entre 1 e 60
            while (numeros.size() < 6) {
                numeros.add(aleatorio.nextInt(60) + 1);
            }

            // Escreve o conteúdo HTML da resposta
            escritor.println("<!DOCTYPE html>");
            escritor.println("<html>");
            escritor.println("<head>");
            escritor.println("<title>ServletAleatorio</title>");
            escritor.println("</head>");
            escritor.println("<body>");
            escritor.println("<table border='1'>");
            escritor.println("<tr><th>Números Aleatórios</th></tr>");
            // Escreve cada número aleatório em uma nova linha da tabela
            for (Integer numero : numeros) {
                escritor.println("<tr><td>" + numero + "</td></tr>");
            }
            escritor.println("</table>");
            escritor.println("</body>");
            escritor.println("</html>");
        }
    }
}