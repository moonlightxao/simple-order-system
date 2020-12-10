package edu.njust.controller;


import edu.njust.pojo.*;
import edu.njust.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class ManageController {
    @Autowired
    private BackStageService service;

    /*处理查询菜品类型请求*/
    @RequestMapping("/DishType")
    public String toManageDishType(Model model){
        List<DishType> all = service.allDishType();
        List<Dish> dishByType = null;
        if(all != null){
            dishByType = service.allDishByType(all.get(0));
        }
        model.addAttribute("types",all);
        model.addAttribute("dishByType",dishByType);
        return "backstage/dishManage";
    }

    /*处理查询某一特定菜品类型的所有菜品请求*/
    @RequestMapping("/queryDish")
    public String queryDish(int typeId, Model model){
        DishType type = service.getDishTypeById(typeId);
        List<DishType> all = service.allDishType();
        List<Dish> list = service.allDishByType(type);
        if(list != null){
            model.addAttribute("types",all);
            model.addAttribute("dishByType",list);
            return "backstage/dishManage";
        }
        return "admin/DishType";
    }

    /*处理到新增菜品页面的请求*/
    @RequestMapping("/toCreateDish")
    public String toCreateDish(Model model){
        List<DishType> allType = service.allDishType();
        model.addAttribute("types",allType);
        return "backstage/dish_add";

    }

    /*处理新增菜品的请求*/
    @PostMapping("/createDish")
    public String createDish(Dish dish, @RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) throws IOException {
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        /*String filePath = "D://pic//"; // 上传后的路径*/
        fileName = System.currentTimeMillis() + suffixName; // 新文件名
        /*File dest = new File(filePath + fileName);*/
        File dest1 = new File("C://Users//柳智添//Desktop//111//customerorder//public//pic//" + fileName);
        if (!dest1.getParentFile().exists()) {
            dest1.getParentFile().mkdirs();
        }
        try {
            /*file.transferTo(dest);*/
            file.transferTo(dest1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        /*System.out.println("filename = "+filename);
        System.out.println("fileName = "+fileName);*/
        dish.setPicUrl(fileName);
        service.addDish(dish);
        List<DishType> all = service.allDishType();
        List<Dish> dishByType = null;
        if(all != null){
            dishByType = service.allDishByType(all.get(0));
        }
        model.addAttribute("types",all);
        model.addAttribute("dishByType",dishByType);
        return "backstage/dishManage";
    }

    /*处理删除菜品的请求*/
    @RequestMapping("/delete/{id}")
    public String deleteDish(@PathVariable("id") Integer dishId, Model model){
        Dish dish = service.getDishById(dishId);
        DishType dishType = service.getDishTypeById(dish.getDishTypeId());
        service.deleteDish(dish.getId());
        return "redirect:/admin/DishType";
    }

    /*处理进入到历史账单管理页面的请求跳转*/
    @RequestMapping("/toHistoryBill")
    public String toHistoryBill(Model model){
        List<Orders> list = service.historyOrders();
        model.addAttribute("historyBill",list);
        return "backstage/history_bill";
    }

    /*处理进入到活账单管理页面的请求跳转*/
    @RequestMapping("/toLivingBill")
    public String toLivingBill(Model model){
        List<Orders> list = service.allLivingOrders();
        model.addAttribute("livingBill",list);
        return "backstage/live_bill";
    }

    /*处理结账请求*/
    @RequestMapping("/checkout/{id}")
    public String checkOut(@PathVariable("id") Integer orderId, Model model){
        System.out.println("orderId = " + orderId);
        service.checkout(orderId);
        List<Orders> list = service.allLivingOrders();
        model.addAttribute("livingBill",list);
        return "backstage/live_bill";
    }

    /*处理进入到餐桌管理页面的请求*/
    @RequestMapping("/toManageTable")
    public String toManageTable(Model model){
        List<Tables> list = service.allTables();
        model.addAttribute("tables",list);
        return "backstage/table";
    }

    /*处理跳转到修改账号信息页面的请求*/
    @RequestMapping("/toModifyAccount")
    public String toModifyAccount(Model model, HttpServletRequest request){
        Admin curUser = service.getAdminByUsr((String) request.getSession().getAttribute("curUser"));
        if(curUser != null){
            model.addAttribute("user",curUser);
        }
        return "backstage/account";
    }

    /*1.处理用户修改账号信息的请求*/
    @RequestMapping("/modifyAccount")
    public String modifyAccount(Admin admin, Model model){
        System.out.println(admin);
        boolean state = service.updateAccount(admin);
        if(state == false){
            model.addAttribute("msg","异常，请重新登录");
            return "sign-in";
        }
        model.addAttribute("msg","修改成功，请重新登录");
        return "sign-in";
    }
    @RequestMapping("/toAddTable")
    public String toAddTable(){
        return "backstage/table_add";
    }
    @RequestMapping("/addTable")
    public String addTable(Tables tables){
        tables.setState(0);
        service.addNewTable(tables);
        return "redirect:/admin/toManageTable";
    }
    @RequestMapping("/deleteTable/{id}")
    public String deleteTable(@PathVariable("id") int tableId){
        service.deleteTableById(tableId);
        return "redirect:/admin/toManageTable";
    }
}
