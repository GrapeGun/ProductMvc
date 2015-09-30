package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FGN on 2015/9/30.
 */
@Controller
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct(){
        logger.info("inputProduct Called");
        return "ProductForm";
    }

    @RequestMapping("/product_save")
    public String saveProduct(ProductForm productForm,Model model){
        logger.info("saveProduct Called");
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        model.addAttribute("product",product);
        return "ProductDetails";
    }



}
