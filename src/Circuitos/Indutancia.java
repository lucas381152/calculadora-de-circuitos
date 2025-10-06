package Circuitos;

import java.util.Scanner;

public class Indutancia {
    private Scanner s;
    private double indutancia;
    private double permeabilidadeNucleo;
    
    // Construtor
    public Indutancia() {
        this.s = new Scanner(System.in);
        this.indutancia = 0;
        this.permeabilidadeNucleo = 0;
    }
    
    /**
     * Calcula a indutância de um indutor considerando o tipo de núcleo
     * Fórmula: L = (μ * N² * A) / l
     * Onde:
     * L = Indutância (Henry)
     * μ = Permeabilidade do núcleo (H/m)
     * N = Número de espiras
     * A = Área da seção transversal (m²)
     * l = Comprimento do núcleo (m)
     */
    public double calcularIndutancia() {
        try {
            System.out.println("\n=== CÁLCULO DE INDUTÂNCIA ===");
            
            // Solicita número de espiras
            System.out.print("Digite o número de espiras (N): ");
            double espiras = s.nextDouble();
            if (espiras <= 0) {
                throw new IllegalArgumentException("Número de espiras deve ser maior que zero!");
            }
            
            // Solicita área da seção transversal
            System.out.print("Digite a área da seção transversal em m² (A): ");
            double area = s.nextDouble();
            if (area <= 0) {
                throw new IllegalArgumentException("Área deve ser maior que zero!");
            }
            
            // Solicita comprimento do núcleo
            System.out.print("Digite o comprimento do núcleo em metros (l): ");
            double comprimento = s.nextDouble();
            if (comprimento <= 0) {
                throw new IllegalArgumentException("Comprimento deve ser maior que zero!");
            }
            
            // Menu para seleção do tipo de núcleo
            double permeabilidade = selecionarNucleo();
            
            // Calcula a indutância usando a fórmula
            indutancia = (permeabilidade * Math.pow(espiras, 2) * area) / comprimento;
            
            System.out.printf("Permeabilidade do núcleo selecionado: %.2e H/m\n", permeabilidade);
            
            return indutancia;
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Método para selecionar o tipo de núcleo e retornar sua permeabilidade
     */
    private double selecionarNucleo() {
        System.out.println("\n--- SELECIONE O TIPO DE NÚCLEO ---");
        System.out.println("1 - Núcleo de Ar (μ = 4π × 10⁻⁷ H/m)");
        System.out.println("2 - Núcleo de Ferro (μ ≈ 6.3 × 10⁻³ H/m)");
        System.out.println("3 - Núcleo de Ferrite (μ ≈ 1.26 × 10⁻³ H/m)");
        System.out.println("4 - Núcleo de Aço Silício (μ ≈ 5.0 × 10⁻³ H/m)");
        System.out.print("Digite a opção: ");
        
        int opcaoNucleo = s.nextInt();
        
        switch (opcaoNucleo) {
            case 1:
                // Permeabilidade do vácuo/ar
                return 4 * Math.PI * Math.pow(10, -7);
                
            case 2:
                // Permeabilidade relativa do ferro ~5000 vezes o vácuo
                return 5000 * 4 * Math.PI * Math.pow(10, -7);
                
            case 3:
                // Permeabilidade relativa da ferrite ~1000 vezes o vácuo
                return 1000 * 4 * Math.PI * Math.pow(10, -7);
                
            case 4:
                // Permeabilidade relativa do aço silício ~4000 vezes o vácuo
                return 4000 * 4 * Math.PI * Math.pow(10, -7);
                
            default:
                System.out.println("Opção inválida! Usando núcleo de ar como padrão.");
                return 4 * Math.PI * Math.pow(10, -7);
        }
    }
    
    /**
     * Método para calcular indutância com valores já fornecidos
     */
    public double calcularIndutancia(double espiras, double area, double comprimento, int tipoNucleo) {
        double permeabilidade;
        
        switch (tipoNucleo) {
            case 1: permeabilidade = 4 * Math.PI * Math.pow(10, -7); break;
            case 2: permeabilidade = 5000 * 4 * Math.PI * Math.pow(10, -7); break;
            case 3: permeabilidade = 1000 * 4 * Math.PI * Math.pow(10, -7); break;
            case 4: permeabilidade = 4000 * 4 * Math.PI * Math.pow(10, -7); break;
            default: permeabilidade = 4 * Math.PI * Math.pow(10, -7);
        }
        
        this.indutancia = (permeabilidade * Math.pow(espiras, 2) * area) / comprimento;
        this.permeabilidadeNucleo = permeabilidade;
        
        return indutancia;
    }
    
    // Getters e Setters
    public double getIndutancia() {
        return indutancia;
    }
    
    public void setIndutancia(double indutancia) {
        this.indutancia = indutancia;
    }
    
    public double getPermeabilidadeNucleo() {
        return permeabilidadeNucleo;
    }
    
    public void setPermeabilidadeNucleo(double permeabilidadeNucleo) {
        this.permeabilidadeNucleo = permeabilidadeNucleo;
    }
    
    /**
     * Fecha o scanner (importante para evitar vazamento de recursos)
     */
    public void fecharScanner() {
        if (s != null) {
            s.close();
        }
    }
}