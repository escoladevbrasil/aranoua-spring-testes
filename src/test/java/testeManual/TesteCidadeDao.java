package testeManual;

import java.util.List;

import javax.persistence.EntityManager;

import dao.CidadeDao;
import model.Cidade;
import util.JPAUtil;

public class TesteCidadeDao {


    private static void inserirDao(){

        EntityManager em = JPAUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao(em);

        Cidade cidade = new Cidade();
        cidade.setNome("Vitoria");

        em.getTransaction().begin();
        cidadeDao.inserir(cidade);
        em.getTransaction().commit();

        em.close();


    }

    private static void listarDao() {

        EntityManager em = JPAUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao(em);

        List<Cidade> cidades= cidadeDao.listar();

        for(Cidade c: cidades){
            System.out.println(c.getId()+" - "+c.getNome());
        }

        em.close();

    }


    private static void consultarDao(){

        EntityManager em = JPAUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao(em);

        Cidade cidade = cidadeDao.consultar(9L);

        System.out.println(cidade.getNome());

        em.close();

    }

    private static void removerDao(){

        EntityManager em = JPAUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao(em);

        em.getTransaction().begin();
        cidadeDao.remover(7L);
        em.getTransaction().commit();

        em.close();

    }



    public static void main(String[] args) {

        inserirDao();
        consultarDao();
        removerDao();
        listarDao();


    }


}
