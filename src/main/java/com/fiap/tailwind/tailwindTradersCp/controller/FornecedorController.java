package com.fiap.tailwind.tailwindTradersCp.controller;

import com.fiap.tailwind.tailwindTradersCp.model.Fornecedor;
import com.fiap.tailwind.tailwindTradersCp.repository.FornecedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @RequestMapping (method =RequestMethod.GET,value = "/cadastrofornecedor")
    public ModelAndView inicio(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Cadastrado");
        ModelAndView modelAndView= new ModelAndView("cadastro/cadastrofornecedor");
        modelAndView.addObject("fornecedorobj", new Fornecedor());
        return modelAndView;
    }



    @RequestMapping(method = RequestMethod.POST ,value="**/salvarfornecedor")
    public ModelAndView salvar(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
        ModelAndView andView= new ModelAndView("cadastro/cadastrofornecedor");
        Iterable<Fornecedor> fornecedorsIt = fornecedorRepository.findAll();
        andView.addObject("fornecedores",fornecedorsIt);
       andView.addObject("fornecedorobj", new Fornecedor());
        return andView;
    }

    @RequestMapping(method=RequestMethod.GET,value="/listafornecedores")
   public ModelAndView fornecedores(){
        ModelAndView andView= new ModelAndView("cadastro/cadastrofornecedor");
        Iterable<Fornecedor> fornecedorsIt = fornecedorRepository.findAll();
        andView.addObject("fornecedores",fornecedorsIt);
        andView.addObject("fornecedorobj", new Fornecedor());
        return andView;
   }

   @GetMapping ("/editarfornecedor/{idfornecedor}")
    public ModelAndView editar(@PathVariable("idfornecedor")Long idfornecedor){
       Optional<Fornecedor> fornecedor= fornecedorRepository.findById(idfornecedor);
       ModelAndView modelAndView= new ModelAndView("cadastro/cadastrofornecedor");
       modelAndView.addObject("fornecedorobj",fornecedor.get());
       return modelAndView;
   }
    @GetMapping ("/excluirfornecedor/{idfornecedor}")
    public ModelAndView excluir(@PathVariable("idfornecedor")Long idfornecedor){
        fornecedorRepository.deleteById(idfornecedor);
        ModelAndView modelAndView= new ModelAndView("cadastro/cadastrofornecedor");
        modelAndView.addObject("fornecedores",fornecedorRepository.findAll());
        modelAndView.addObject("fornecedorobj",new Fornecedor());
        return modelAndView;
    }







}
