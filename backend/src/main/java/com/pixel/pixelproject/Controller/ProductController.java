package com.pixel.pixelproject.Controller;

import static com.pixel.pixelproject.Controller.ApiPath.*;

import com.pixel.pixelproject.Entity.Product;
import com.pixel.pixelproject.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(ROOT + PRODUCTS)
@Api(tags = "Pixel Product controller")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Get all products", tags = "getProducts", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data loaded successull"),
            @ApiResponse(code = 403, message = "User have not access"),
            @ApiResponse(code = 404, message = "No products found")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = PRODUCT, produces = APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable(ID) UUID id) {
        return productService.getProduct(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping(PRODUCT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable(ID) UUID id) {
        productService.deleteProduct(id);
    }

    @GetMapping(SEARCH)
    public List<Product> searchProducts(@RequestParam String query) {
        return productService.findProducts(query);
    }
}
