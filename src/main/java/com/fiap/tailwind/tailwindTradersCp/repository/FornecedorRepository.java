package com.fiap.tailwind.tailwindTradersCp.repository;

import com.fiap.tailwind.tailwindTradersCp.model.Fornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FornecedorRepository extends CrudRepository<Fornecedor,Long> {

}
