import models.Product;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = { "/danh-sach-san-pham", "/products-list" })
public class ProductServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("=== ProductServlet được gọi đến lần đầu.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product[] products = {
                new Product("Dell XPS 15", 2000000f, "https://www.anphatpc.com.vn/media/product/21897_dell_xps_15_9550_fyk3f1.jpg"),
                new Product("ASUS 15", 1000000f, "https://www.anphatpc.com.vn/media/product/21897_dell_xps_15_9550_fyk3f1.jpg"),
                new Product("Macbook Pro 15", 1500000f, "https://www.anphatpc.com.vn/media/product/21897_dell_xps_15_9550_fyk3f1.jpg"),
        };

        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("danh-sach-san-pham.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Đã bị huỷ!");
    }
}
