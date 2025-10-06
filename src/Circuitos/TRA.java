package Circuitos;

import java.util.Scanner;

public class TRA implements Circ {
    Scanner s = new Scanner(System.in);

    private double ampere;
    private double resistencia;
    private double tensao;

    // construtores

    public TRA(double ampere, double resistencia, double tensao, double resultado) {

        this.ampere = ampere;
        this.resistencia = resistencia;
        this.tensao = tensao;
    }
     
    
    public double calcularTensao() {

        System.out.print("Digite o ampere: ");
        ampere = s.nextDouble();
        if (ampere < 0) {
            throw new IllegalArgumentException("ampere não pode ser negativo!");
        }

        System.out.print("Digite a resistencia:  ");
        resistencia = s.nextDouble();
        if (resistencia < 0) {
            throw new IllegalArgumentException("a resistencia não pode ser negativo!");

        }

        return (ampere * resistencia);

        
    }

    public double calcularResistencia() {

        System.out.print("Digite o tensao: ");
        tensao = s.nextDouble();

        if (tensao < 0) {
            throw new IllegalArgumentException("tensao não pode ser negativo!");
        }
        System.out.print("Digite a ampere:  ");
        ampere = s.nextDouble();
        if (ampere < 0) {
            throw new IllegalArgumentException("ampere não pode ser negativo!");

        }
        return (tensao / ampere);
    }

    public double calcularAmpere() {

        System.out.print("Digite o tensao: ");
        tensao = s.nextDouble();

        if (tensao < 0) {
            throw new IllegalArgumentException("tensao não pode ser negativo!");
        }
        System.out.print("Digite a resitencia:  ");
        resistencia = s.nextDouble();
        if (resistencia < 0) {
            throw new IllegalArgumentException("A resistencia não pode ser negativo!");
        }

        return (tensao / resistencia);

       
    }
   
    // get set

    public double getAmpere() {
        return ampere;
    }

    public void setAmpere(double ampere) {

        this.ampere = ampere;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {

        this.resistencia = resistencia;

    }

    public double getTensao() {
        return tensao;
    }

    public void setTensao(double tensao) {

        this.tensao = tensao;

    }
    

}
