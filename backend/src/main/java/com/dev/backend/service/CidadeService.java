package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.Cidadereposityory;

@Service

public class CidadeService {
    @Autowired
    private Cidadereposityory cidaderepository;

    public List<Cidade> buscarTodos(){
        return cidaderepository.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidaderepository.saveAndFlush(cidade);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidaderepository.saveAndFlush(cidade);
    }

    public void excluir(Long id){
        Cidade cidade = cidaderepository.findById(id).get();
        cidaderepository.delete(cidade);
    }
}
