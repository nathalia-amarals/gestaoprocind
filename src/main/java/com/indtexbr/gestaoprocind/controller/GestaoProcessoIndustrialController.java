package com.indtexbr.gestaoprocind.controller;

import com.indtexbr.gestaoprocind.entity.Produto;
import com.indtexbr.gestaoprocind.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("gestaoprocind")
public class GestaoProcessoIndustrialController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<Produto> leProduto(@RequestParam("id")Long id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.get()!=null)
            return new ResponseEntity<Produto>(optionalProduto.get(),HttpStatus.OK);
        return new ResponseEntity<Produto>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Produto> criaProduto(@RequestBody Produto produto){
        return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
    }
}
