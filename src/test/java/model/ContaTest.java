package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTest {

    private Conta conta;

    private static double valorDeposito;
    private static double valorSaqueValido;
    private static double valorSaqueInvalido;
    private static double valorZerado;


    @BeforeAll
    private static void preparaValores(){
        valorDeposito = 100.75;
        valorSaqueValido = 50.00;
        valorSaqueInvalido = 150.25;
        valorZerado = 0.00;
    }


    @BeforeEach
    private void preparaPreCondicao(){
        this.conta = new Conta();
        conta.ativar();
    }

    @Test
    public void deveDepositarComValorValido(){

        conta.depositar(valorDeposito);

        Assertions.assertEquals(valorDeposito,conta.getSaldo());

    }

    @Test
    public void naoDeveDepositarComContaInativa(){

        conta.desativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(valorDeposito));

        Assertions.assertEquals(valorZerado,conta.getSaldo());
    }

    @Test
    public void deveSacarComValorMenorQueOSaldo(){

        conta.depositar(valorDeposito);

        conta.sacar(valorSaqueValido);

        Assertions.assertEquals(valorDeposito- valorSaqueValido, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarComContaInativa(){

        conta.depositar(valorDeposito);

        conta.desativar();

        Assertions.assertThrows(IllegalStateException.class, () -> conta.sacar(valorSaqueValido));

    }

    @Test
    public void naoDeveSacarComValorMaiorQueOSaldo(){

        conta.depositar(valorDeposito);

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(valorSaqueInvalido) );

        Assertions.assertEquals(valorDeposito, conta.getSaldo());

    }

}
