package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.Marcarepository;

@Service
public class MarcaService {
    @Autowired
    private Marcarepository marcarepository;

    public List<Marca> buscarTodos(){
        return marcarepository.findAll();
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcarepository.saveAndFlush(marca);
        return marcaNovo;        
    }

    public Marca alterar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcarepository.saveAndFlush(marca);
    }

    public void excluir(Long id){
        Marca marca = marcarepository.findById(id).get();
        marcarepository.delete(marca);
    }
}
