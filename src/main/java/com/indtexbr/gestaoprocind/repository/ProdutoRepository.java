package com.indtexbr.gestaoprocind.repository;

import com.indtexbr.gestaoprocind.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto,Long> {
}
