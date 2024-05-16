
package br.unipar.manipulacao.arquivos.dao;

import br.unipar.manipulacao.arquivos.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class PessoaDAOImp implements PessoaDAO{
    
    private EntityManager entityManager;

    public PessoaDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public Pessoa save(Pessoa pessoa) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.merge(pessoa);
        } else {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        }
        return null;
    }

    @Override
    public Pessoa update(Pessoa p) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(p);
        transaction.commit();
        entityManager.close();

        System.out.println("Pessoa atualizada com sucesso!");
        return p;    }

    @Override
    public Boolean delete(Pessoa p) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(p);
            transaction.commit();
            entityManager.close();

            System.out.println("Pessoa removida com sucesso!");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Pessoa atualizada com sucesso!");
            return false;
        }
    }

    @Override
    public Pessoa findById(Integer id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("SELECT p FROM Pessoa p",
                Pessoa.class).getResultList();    }
    
}
