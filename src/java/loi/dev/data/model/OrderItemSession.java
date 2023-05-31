package loi.dev.data.model;

import java.io.Serializable;

/**
 *
 * @author ACER NITRO
 */
public class OrderItemSession implements Serializable {

    private int productId;
    private String productName;
    private int quantity;
    private double productPrice;

    public OrderItemSession(int productId, String productName, int quantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    
}
