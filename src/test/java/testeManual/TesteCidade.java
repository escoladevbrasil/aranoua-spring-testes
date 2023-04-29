package testeManual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cidade;

public class TesteCidade {

    public static void main(String[] args) {

//        Inicialização
        EntityManagerFactory fabrica =
                Persistence.createEntityManagerFactory("springtestes-jpa-pu");

        EntityManager em = fabrica.createEntityManager();

//        Insere um registo no banco de dados.

//        Cidade cidade = new Cidade();
//        cidade.setNome("Manaus");
//        cidade.setEstado("Amazonas");
//
//        em.getTransaction().begin();
//
//        em.persist(cidade);
//
//        em.getTransaction().commit();

//        Listar os registros no banco de dados

//      SQL (Structured Query Language): select id,nome,estado from cidade;
//      JPQL (Java Persistence Query Language): select cidade from Cidade cidade

        Query consulta = em.createQuery("select cidade from Cidade cidade");

        List<Cidade> cidades = consulta.getResultList();

        for(Cidade c:cidades){
            System.out.println("Nome:"+c.getNome()+" Estado:"+c.getEstado());
        }



        em.close();
    }

}
