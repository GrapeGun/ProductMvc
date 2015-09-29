package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import validator.ProductValidator;

public class SaveProductController implements Controller {
    private static final Log logger = LogFactory.getLog(SaveProductController.class);
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response)  {

        ProductForm productForm = new ProductForm();
        // populate action properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        // validate ProductForm
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if (errors.isEmpty()) {
            // create Product from ProductForm
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            request.setAttribute("product", product);
            return new ModelAndView("/ProductDetails","product",product);
        } else {
            // store errors and form in a scope variable for the view
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("errors",errors);
            map.put("form",productForm);
            return new ModelAndView("/ProductForm",map);
        }
    }

}
