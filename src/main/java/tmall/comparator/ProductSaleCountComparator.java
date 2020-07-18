package tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author Yuery
 * @date 2020/7/17/0017 - 13:24
 */
public class ProductSaleCountComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
       return p2.getSaleCount()-p1.getSaleCount();
    }
}
