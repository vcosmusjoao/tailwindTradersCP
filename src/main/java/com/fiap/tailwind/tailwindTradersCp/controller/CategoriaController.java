package com.fiap.tailwind.tailwindTradersCp.controller;
import com.fiap.tailwind.tailwindTradersCp.model.Categoria;
import com.fiap.tailwind.tailwindTradersCp.repository.CategoriaRepository;
import com.fiap.tailwind.tailwindTradersCp.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoriaController {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;


    @RequestMapping (method =RequestMethod.GET,value = "/cadastrocategoria")
    public ModelAndView inicio(){
        ModelAndView modelAndView= new ModelAndView("cadastro/cadastrocategoria");
        modelAndView.addObject("categoriaobj", new Categoria());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST ,value="**/salvarcategoria")
    public ModelAndView salvar(Categoria categoria){
        categoriaRepository.save(categoria);
        ModelAndView andView= new ModelAndView("cadastro/cadastrocategoria");
        Iterable<Categoria> categoriaIt = categoriaRepository.findAll();
        andView.addObject("categorias",categoriaIt);
        andView.addObject("categoriaobj", new Categoria());
        return andView;
    }

    @RequestMapping(method=RequestMethod.GET,value="/listacategorias")
    public ModelAndView categorias(){
        ModelAndView andView= new ModelAndView("cadastro/cadastrocategoria");
        Iterable<Categoria> categoriaIt = categoriaRepository.findAll();
        andView.addObject("categorias",categoriaIt);
        andView.addObject("categoriaobj", new Categoria());
        return andView;
    }
    @GetMapping ("/editarcategoria/{idcategoria}")
    public ModelAndView editar(@PathVariable("idcategoria")Long idcategoria){
        Optional<Categoria> categoria= categoriaRepository.findById(idcategoria);
        ModelAndView modelAndView= new ModelAndView("cadastro/cadastrocategoria");
        modelAndView.addObject("categoriaobj",categoria.get());
        return modelAndView;
    }

    @GetMapping("/excluircategoria/{idcategoria}")
    public ModelAndView excluir(@PathVariable("idcategoria")Long idcategoria){
        categoriaRepository.deleteById(idcategoria);
        ModelAndView modelAndView= new ModelAndView("cadastro/cadastrocategoria");
        modelAndView.addObject("categorias",categoriaRepository.findAll());
        modelAndView.addObject("categoriaobj",new Categoria());
        return modelAndView;
    }

}
