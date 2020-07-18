package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Yuery
 * @date 2020/7/15/0015 - 17:49
 */
@Controller
@RequestMapping("")
public class OrderController {
    //因为订单的增加和删除，都是在前台进行的。 所以OrderController提供的是list方法和delivery(发货)方法
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<Order> os = orderService.list();

        int total = (int) new PageInfo<> (os).getTotal();
        page.setTotal(total);
        orderItemService.fill(os);//实现一对多，一个订单多个订单项
        model.addAttribute("os",os);
        model.addAttribute("page",page);
        return "admin/listOrder";
    }
    @RequestMapping("admin_order_delivery")
    public String delivery(Order o) throws IOException{
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return "redirect:admin_order_list";
    }
}
