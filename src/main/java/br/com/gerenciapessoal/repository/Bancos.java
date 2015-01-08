/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository;

import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.repository.filter.BancoFilter;
import br.com.gerenciapessoal.util.jpa.Transactional;
import br.com.gerenciapessoal.util.service.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jalima
 */
public class Bancos implements Serializable {

    @Inject
    private EntityManager manager;

    public Banco gardar(Banco banco) {
        return manager.merge(banco);
    }

    public List<Banco> filtrados(BancoFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Banco.class);

        if (StringUtils.isNotBlank(filter.getNumBanco())) {
            criteria.add(Restrictions.eq("numBanco", filter.getNumBanco()));
        }

        if (StringUtils.isNotBlank(filter.getNome())) {
            criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
        }

        if (StringUtils.isNotBlank(filter.getUf())) {
            criteria.add(Restrictions.ilike("uf", filter.getUf(), MatchMode.ANYWHERE));
        }

        if (StringUtils.isNotBlank(filter.getEstado())) {
            criteria.add(Restrictions.ilike("estado", filter.getEstado(), MatchMode.ANYWHERE));
        }

        if (StringUtils.isNotBlank(filter.getEndereco())) {
            criteria.add(Restrictions.ilike("endereco", filter.getEndereco(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("numBanco")).list();
    }

    @Transactional
    @SuppressWarnings("UnusedAssignment")
    public void remover(Banco banco) {
        try {
            banco = porId(banco.getId());

            manager.remove(banco);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Banco não pode ser excluido");
        }
    }

    public Banco porId(Long id) {
        return manager.find(Banco.class, id);
    }

    @SuppressWarnings("JPQLValidation")
    public List<Banco> listaBanco() {
        return manager.createQuery("from Banco", Banco.class).getResultList();
    }

}
