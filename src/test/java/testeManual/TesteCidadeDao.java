package testeManual;

import java.util.List;

import dao.CidadeDao;
import model.Cidade;

public class TesteCidadeDao {


    private static void inserirDao(){

        CidadeDao cidadeDao = new CidadeDao();

        Cidade cidade = new Cidade();

        cidade.setNome("Campinas");

        cidadeDao.inserir(cidade);

    }

    private static void listarDao() {

        CidadeDao cidadeDao = new CidadeDao();

        List<Cidade> cidades= cidadeDao.listar();

        for(Cidade c: cidades){
            System.out.println(c.getId()+" - "+c.getNome());
        }

    }


    private static void consultarDao(){

        CidadeDao cidadeDao = new CidadeDao();

        Cidade cidade = cidadeDao.consultar(8L);

        System.out.println(cidade.getNome());

    }

    private static void removerDao(){

        CidadeDao cidadeDao = new CidadeDao();

        cidadeDao.remover(8L);
    }



    public static void main(String[] args) {


//        inserirDao();
//        consultarDao();
        removerDao();
        listarDao();


    }


}
