import model.OrderDetail;
import model.Orders;
import service.OrderDetailService;
import service.OrderService;
import service.ProductService;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // init ProductService
            ProductService productService = new ProductService();
            OrderService orderService = new OrderService();
            OrderDetailService orderDetailService = new OrderDetailService();
//            orderService.insert(new Orders(Date.valueOf(LocalDate.of(2025, 5, 18)), 100));
//            System.out.println(orderService.getAll());
            System.out.println(orderService.exportCSV());
            System.out.println(productService.exportCSV());
            OrderDetail o = new OrderDetail(3, 3, 2);
            orderDetailService.insert(o);
            System.out.println(orderDetailService.exportCSV());
//            Product product = new Product(120, "鴛鴦奶茶2", ProductStatusEnum.OutOfStock);
//            productService.insert(product);
//            System.out.println(product);
//            System.out.println(ProductStatusEnum.getEnum("out-of-stock"));
//            Product product1 = productService.get(4);
//            System.out.println(productService.getSaleProducts());
//            System.out.println(productService.insert(product));
//            List<Product> productList = productService.getAll();
//            System.out.println(productList);
//            if (!productList.isEmpty()) {
//                System.out.println(productList.get(2));
//                Product product1 = productService.get(4);
//                System.out.println(product1);
//                product1.setPrice(200);
//                product1.setName("香草拿鐵");
//                boolean success = productService.update(product1);
//                if (success) {
//                    product1 = productService.get(4);
//                    System.out.println(product1);
//                }
//            }
//            System.out.println(productService.getProductByName("拿鐵"));
//            boolean success = productService.delete(1);
//            if (success) {
//                System.out.println(productService.get(1));
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}