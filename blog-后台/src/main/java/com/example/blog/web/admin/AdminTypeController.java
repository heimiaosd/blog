package com.example.blog.web.admin;

import com.example.blog.po.Type;
import com.example.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminTypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String typesInput(){
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes redirectAttributes){
        if(type==null){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }else {
            typeService.saveType(type);
            redirectAttributes.addFlashAttribute("message","操作成功");
        }



        return "redirect:/admin/types";
    }
}
