package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.Estadorepository;

@Service

public class EstadoService {
    
    @Autowired
    private Estadorepository estadorepository;

    public List<Estado> buscarTodos(){
        return estadorepository.findAll();
    }


    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadorepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadorepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadorepository.findById(id).get();
        estadorepository.delete(estado);
    }
}
