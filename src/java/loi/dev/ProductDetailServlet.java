/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.ProductDao;
import loi.dev.data.model.Product;

/**
 *
 * @author ACER NITRO
 */
public class ProductDetailServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        
        List<Product> relatedProductList = productDao.relatedProductList(product);
        
        request.setAttribute("product", product);
        request.setAttribute("relatedProductList", relatedProductList);
        request.getRequestDispatcher("product-detail.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
