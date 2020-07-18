package tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author Yuery
 * @date 2020/7/17/0017 - 13:13
 */
public class ProductDateComparator implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return p2.getCreateDate().compareTo(p1.getCreateDate());
    }
}
