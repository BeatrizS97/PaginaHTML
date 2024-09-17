import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Definindo a URL onde este servlet será acessado
@WebServlet("/greeting.html")
public class GreetingServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        // Serve para definir o tipo de conteúdo da resposta como HTML com codificação UTF-8
        resposta.setContentType("text/html;charset=UTF-8");
        
        // Faz uso de um PrintWriter para escrever a resposta HTML
        try (PrintWriter escritor = resposta.getWriter()) {
            // Dá ao usuário a hora atual
            LocalTime agora = LocalTime.now();
            String saudacao;
            
            // Tem a função de determinar a saudação com base na hora atual
            if (agora.isBefore(LocalTime.NOON)) {
                saudacao = "Bom dia";
            } else if (agora.isBefore(LocalTime.of(18, 0))) {
                saudacao = "Boa tarde";
            } else if (agora.isBefore(LocalTime.of(22, 0))) {
                saudacao = "Boa noite";
            } else {
                saudacao = "Vá dormir";
            }

            // Escreve o conteúdo HTML da resposta
            escritor.println("<!DOCTYPE html>");
            escritor.println("<html>");
            escritor.println("<head>");
            escritor.println("<title>SaudacaoServlet</title>");
            escritor.println("</head>");
            escritor.println("<body>");
            escritor.println("<h1>" + saudacao + "</h1>"); // Exibe a saudação baseada na hora do dia
            escritor.println("<p>Data e hora atual: " + agora + "</p>"); // Exibe a data e hora atual
            escritor.println("</body>");
            escritor.println("</html>");
        }
    }
}