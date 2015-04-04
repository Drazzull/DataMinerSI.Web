/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Hibernate4Util;
import java.util.List;
import model.Pessoa;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Drazzull
 */
public class PessoaDao
{

    public int getNumberByEstadoCivil(String estadoCivil)
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.add(Restrictions.eq("estadoCivil", estadoCivil));
            cr.setProjection(Projections.rowCount());
            int resultado = ((Number) cr.uniqueResult()).intValue();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar o estado civil. Erro: " + e.getMessage());
        }

        return 0;
    }

    public int getNumberByGrauInstrucao(String grauInstrucao)
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.add(Restrictions.eq("grauInstrucao", grauInstrucao));
            cr.setProjection(Projections.rowCount());
            int resultado = ((Number) cr.uniqueResult()).intValue();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar o grau de instrução. Erro: " + e.getMessage());
        }

        return 0;
    }

    public int getNumberByFilhos(int filhos)
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.add(Restrictions.eq("numeroFilhos", filhos));
            cr.setProjection(Projections.rowCount());
            int resultado = ((Number) cr.uniqueResult()).intValue();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar o número de filhos. Erro: " + e.getMessage());
        }

        return 0;
    }

    public List<String> getEstadosCivis()
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.setProjection(Projections.groupProperty("estadoCivil").as("estados"));
            cr.addOrder(Order.asc("estados"));
            List<String> resultado = cr.list();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar a lista de estados civis. Erro: " + e.getMessage());
        }

        return null;
    }
    
    public List<String> getGrausInstrucao()
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.setProjection(Projections.groupProperty("grauInstrucao").as("graus"));
            cr.addOrder(Order.asc("graus"));
            List<String> resultado = cr.list();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar a lista de graus de instrução. Erro: " + e.getMessage());
        }

        return null;
    }
    
    public List<Integer> getNumeroFilhos()
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            cr.setProjection(Projections.groupProperty("numeroFilhos").as("filhos"));
            cr.addOrder(Order.asc("filhos"));
            List<Integer> resultado = cr.list();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar a lista de filhos. Erro: " + e.getMessage());
        }

        return null;
    }
    
    public List<Pessoa> getPessoas()
    {
        try
        {
            Session sessao = Hibernate4Util.getSessionFactory();
            Transaction transacao = sessao.beginTransaction();
            Criteria cr = sessao.createCriteria(Pessoa.class);
            List<Pessoa> resultado = cr.list();
            transacao.commit();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Não foi possível buscar a lista de pessoas. Erro: " + e.getMessage());
        }

        return null;
    }
}
