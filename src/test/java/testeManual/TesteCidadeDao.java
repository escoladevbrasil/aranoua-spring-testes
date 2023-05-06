package testeManual;

import dao.CidadeDao;
import model.Cidade;

public class TesteCidadeDao {


    private static void inserirDao(){

        CidadeDao cidadeDao = new CidadeDao();

        Cidade cidade = new Cidade();

        cidade.setNome("Campinas");

        cidadeDao.inserir(cidade);

    }

    public static void main(String[] args) {


        inserirDao();

    }
}
