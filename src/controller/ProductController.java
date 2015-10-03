package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;

/**
 * Created by FGN on 2015/9/30.
 */
@Controller
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product_input")
    public String inputProduct(){
        logger.info("inputProduct Called");
        return "ProductForm";
    }

    // RedirectAttributes 用来保存重定向时的数据
    @RequestMapping(value="/product_save",method = RequestMethod.POST)
    public String saveProduct(ProductForm productForm,RedirectAttributes redirectAttributes){
//    public String saveProduct(ProductForm productForm,Model model){
        logger.info("saveProduct Called");
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        Product savedProduct = productService.add(product);
//        model.addAttribute("product",savedProduct);
//        return "ProductDetails";
        redirectAttributes.addFlashAttribute("message","the product was successfully added");
        // 注意重定向的前缀标识(是不是很明确?)
        return "redirect:/product_view/"+savedProduct.getId();

    }

    // @PathVariable 注解获取url中的路径变量
    @RequestMapping(value = "/product_view/{id}")
    public String viewProduct(@PathVariable Long id,Model model){
        Product product = productService.get(id);
        model.addAttribute("product",product);
        return "ProductView";
    }


}
