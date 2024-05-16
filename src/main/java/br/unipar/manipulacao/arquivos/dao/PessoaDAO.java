package br.unipar.manipulacao.arquivos.dao;

import br.unipar.manipulacao.arquivos.model.Pessoa;
import java.util.List;


public interface PessoaDAO {

    Pessoa save(Pessoa p);

    Pessoa update(Pessoa p);

    Boolean delete(Pessoa p);

    Pessoa findById(Integer id);

    List<Pessoa> findAll();
}
