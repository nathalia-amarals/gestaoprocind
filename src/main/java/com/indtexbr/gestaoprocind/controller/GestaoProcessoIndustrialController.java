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
@RequestMapping("/gestaoprocind")
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
        Produto cadastrado = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(cadastrado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity atualizaProduto(@RequestBody Produto produto){
        Optional<Produto> produtoCadastrado = produtoRepository.findById(produto.getId());
        if(!produtoCadastrado.isEmpty()){
            if(produto.getNome().equals("")){
                produto.setNome(produtoCadastrado.get().getNome());
            }
            if(produto.getReferencia().equals("")){
                produto.setReferencia(produtoCadastrado.get().getReferencia());
            }
            if(produto.getAltura() == 0){
                produto.setAltura(produtoCadastrado.get().getAltura());
            }
            if(produto.getLargura() == 0){
                produto.setLargura(produtoCadastrado.get().getLargura());
            }
            if(produto.getComposicao().equals("")){
                produto.setComposicao(produtoCadastrado.get().getComposicao());
            }
            if(produto.getCor() != null){
                produto.setCor(produtoCadastrado.get().getCor());
            }
            if(produto.getEstado().equals("")){
                produto.setEstado(produtoCadastrado.get().getEstado());
            }
            produtoRepository.save(produto);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletaProduto(@PathVariable("id") Long id){
        Optional<Produto> produtoCadastrado = produtoRepository.findById(id);
        if(!produtoCadastrado.isEmpty())
        {
            produtoRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
