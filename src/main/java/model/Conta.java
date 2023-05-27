package model;

public class Conta {

    private double saldo;

    private boolean ativa;

    public void ativar(){
        this.ativa = true;
    }

    public void desativar(){
        this.ativa = false;
    }

    public double getSaldo() {
        return saldo;
    }
    public void depositar(double valor){

        if(this.ativa) {

            saldo += valor;

        }else{

            throw new RuntimeException("Conta Inativa! Não é possível depositar.");

        }

    }

    public void sacar(double valor){

        if(!this.ativa){ throw new IllegalStateException("Conta Inativa!");}

        if(saldo < valor){ throw new RuntimeException("Saldo menor que o valor de saque!"); }

        saldo -= valor;

    }


}
