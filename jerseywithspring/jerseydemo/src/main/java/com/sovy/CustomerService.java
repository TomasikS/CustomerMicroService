/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy;

/**
 *
 * @author stefan.tomasik
 */
public interface CustomerService {

    void createProduct(Customer product);

    Customer updateProduct(Customer product);

    Customer getProductById(long productId);

    void deleteProduct(long id);
}
