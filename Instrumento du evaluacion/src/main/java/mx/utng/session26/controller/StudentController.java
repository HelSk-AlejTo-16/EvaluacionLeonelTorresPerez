package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.Producto;
import mx.utng.session26.model.service.IStudentService;

@Controller
@SessionAttributes("producto")
public class StudentController {
    
    @Autowired
    private IStudentService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "producto");
        model.addAttribute("productos", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de los productos");
        model.addAttribute("producto", new Producto());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Producto producto, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de los productos");
            return "form";
        }
        service.save(producto);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Producto producto = null;
        if(id>0){
            producto = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("producto", producto);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
