package Circuitos;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        TRA pad = new TRA(0, 0, 0, 0);
          Indutancia ind = new Indutancia();
        int opc = 0;

        while (opc != 5) {
            System.out.println("============================");
            System.out.println("------------MENU-------------");
            System.out.println("1-TENSAO");
            System.out.println("2-RESISTENCIA");
            System.out.println("3-AMPERE");
            System.out.println("4-INDUTANCIA");
            System.out.print("DIGITE UMA OPÇAO: ");
            opc = s.nextInt();

            switch (opc) {

                case 1:
                    System.out.printf(" A tensao e de: %.1f volts\n", pad.calcularTensao());
                    

                    break;

                case 2:

                   System.out.printf(" A resitencia e de: %.1f onhs\n", pad.calcularResistencia());
                    break;

                case 3:
                     System.out.printf(" A resitencia e de: %.1f A\n", pad.calcularAmpere());
                    break;

                case 4:
                      double resultadoIndutancia = ind.calcularIndutancia();
                    if (resultadoIndutancia != -1) {
                        // Formatação especial para indutância (valores podem ser muito pequenos)
                        if (resultadoIndutancia < 0.001) {
                            System.out.printf("A indutância é de: %.2e H\n\n", resultadoIndutancia);
                        } else {
                            System.out.printf("A indutância é de: %.6f H\n\n", resultadoIndutancia);
                        }
                    }
                    
                    break;
                    case 5:
                    System.out.println("saindo....");
                    
                    break;

                default:

                    System.out.println(" opçao invalida");

            }
            

        }
          s.close();

    }

}
