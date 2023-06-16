/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import loi.dev.BaseServlet;
import loi.dev.data.dao.Database;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.GalleryDao;
import loi.dev.data.dao.ProductDao;
import loi.dev.data.model.Category;
import loi.dev.data.model.Gallery;
import loi.dev.data.model.Product;
import loi.dev.util.Constants;
import loi.dev.util.UploadFileHelper;

/**
 *
 * @author ACER NITRO
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EditProductServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = DatabaseDao.getInstance().getProductDao().find(productId);
        List<Category> categoryList = DatabaseDao.getInstance().getCategoryDao().findAll();
        session.setAttribute("product", product);
        session.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("admin/product/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDao productDao = Database.getInstance().getProductDao();

        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDao.find(productId);

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryId(categoryId);

//        if (name.isEmpty() || description.isEmpty() ) {
//            session.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin");
//            request.getRequestDispatcher("admin/product/edit.jsp").forward(request, response);
//        }

        productDao.update(product);

        updateGallery(product.getId(), request);

        response.sendRedirect("IndexProductServlet");
    }

    private void updateGallery(int productId, HttpServletRequest request) {
        GalleryDao galleryDao = DatabaseDao.getInstance().getGalleryDao();
        galleryDao.deleteByProduct(productId);

        List<String> photos = UploadFileHelper.uploadFile(Constants.UPLOAD_DIR, request);
        for (int i = 0; i < photos.size(); i++) {
            Gallery g = new Gallery(Constants.UPLOAD_DIR + "/" + photos.get(i), productId);
            galleryDao.insert(g);
        }
    }

}
