package com.example.blog.controller.admin;

import com.example.blog.po.Type;
import com.example.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String typesInput(Model model) {
       model.addAttribute("type",new Type());
       return "admin/type-input";
    }

    @PostMapping("/types")
    public String addType(@Valid Type type, BindingResult result, RedirectAttributes redirectAttributes){
        Type type1 = typeService.findName(type.getName());
        if(type1!=null){
            result.rejectValue("name","nameError","不能添加重复分类");
        }else {

        }
        if(result.hasErrors()){
            return "admin/type-input";
        }
        if(type==null){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }else {
            typeService.saveType(type);
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String addType(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes redirectAttributes){
        Type type1 = typeService.findName(type.getName());
        if(type1!=null){
            result.rejectValue("name","nameError","不能添加重复分类");
        }else {

        }
        if(result.hasErrors()){
            return "admin/type-input";
        }
        if(type==null){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }else {
            typeService.updateType(id,type);
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/type-input";
    }
}
