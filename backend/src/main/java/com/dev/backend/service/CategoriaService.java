package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.Categoriarepository;

@Service
public class CategoriaService {
    @Autowired
    private Categoriarepository categoriarepository;

    public List<Categoria> buscarTodos(){
        return categoriarepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNovo = categoriarepository.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria alterar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriarepository.saveAndFlush(categoria);
    }

    public void excluir(Long id){
        Categoria categoria = categoriarepository.findById(id).get();
        categoriarepository.delete(categoria);
    }
}
