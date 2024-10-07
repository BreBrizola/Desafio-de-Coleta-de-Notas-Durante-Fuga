import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;

//NOMES: Brenda Brizola de Oliveira e Isadora Morari de Camargo

public class Aplicacao {
    private static int linhas;
    private static int colunas;
    private static char[][] mapa; 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    System.out.println("- Digite o nome do arquivo de texto que contém o mapa(casoC50.txt; casoC100.txt; casoC200.txt e etc): ");
    String nomeArquivo = in.nextLine();
    System.out.println("");

    lerMapa("Arquivos" + File.separator + nomeArquivo);
    // caso o trecho acima nao funcione, use esse:
    //lerMapa("T1_ALEST2"+ File.separator + "Arquivos" + File.separator + nomeArquivo);
    }

    public static void lerMapa(String Mapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(Mapa))) {
            
            String dimensoes = br.readLine();
            String[] dimensoesArray = dimensoes.split(" ");
            linhas = Integer.parseInt(dimensoesArray[0]);
            colunas = Integer.parseInt(dimensoesArray[1]);

            mapa = new char[linhas][colunas];

            String linha;
            int linhaAtual = 0;
            while ((linha = br.readLine()) != null && linhaAtual < linhas) {
                for (int i = 0; i < Math.min(linha.length(), colunas); i++) {
                    mapa[linhaAtual][i] = linha.charAt(i);
                }
                linhaAtual++;
            }
            
            //imprimirMapa();
            analisarMapa();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void analisarMapa() {
        int inicioL = 0; //linha inicial
        int inicioC = 0; // coluna inicial
        int direcao = 0; // 0- direita, 1- esquerda, 2- cima, 3- baixo
    
        for (int l = 0; l < mapa.length; l++) { // Encontra o inicio do mapa, sendo a linha da primeira coluna onde tem um '-'
            if (mapa[l][inicioC] == '-') {
                inicioL = l;
                break;
            }
        }
    
        int l = inicioL;//linhas
        int c = inicioC;//colunas
        StringBuilder caminho = new StringBuilder(); //StringBuilder para construir o caminho por meio de concatenação de Strings
    
        while (mapa[l][c] != '#') {
            char charAtual = mapa[l][c];
            if (charAtual == '-' || charAtual == '|') {
                caminho.append(charAtual); 
            } else if (Character.isDigit(charAtual)) {
                caminho.append(charAtual); 
            } else if (charAtual == '\\' || charAtual == '/') {
                caminho.append(charAtual); 
                if (charAtual == '\\') {
                    if (direcao == 0) {
                        direcao = 3;
                    }
                    else if (direcao == 1) {
                        direcao = 2;
                    }else if (direcao == 2) {
                        direcao = 1;
                    }else if (direcao == 3) {
                        direcao = 0;
                    }
                } else if (charAtual == '/') {
                    if (direcao == 0) {
                        direcao = 2;
                    } else if (direcao == 1) {
                        direcao = 3;
                    }else if (direcao == 2) {
                        direcao = 0;
                    }else if (direcao == 3) direcao = 1;
                }
            }
    
            // Vai para a próxima posição de acordo com a direção
            if (direcao == 0) c++;
            else if (direcao == 1) c--;
            else if (direcao == 2) l--;
            else if (direcao == 3) l++;
    
            // Verificar se está dentro dos limites do mapa
            if (l < 0 || l >= linhas || c < 0 || c >= colunas) break;
        }
    
        String caminhoS = caminho.toString();//Converte o Stringbuilder pra uma String
    
        Stack<Integer> pilha = new Stack<>(); // Pilha pra guardar o dinheiro que foi encontrado
        char[] charCaminho = caminhoS.toCharArray();
        String numero = "";
    
        for (int i = 0; i < charCaminho.length; i++) {
            if (Character.toString(charCaminho[i]).matches("[0-9]")) {//Verifica se o char é um numero
                numero += charCaminho[i];
            } else {
                if (!numero.equals("")) { //Se o numero não for vazio, ele é colocado na pilha
                    pilha.push(Integer.parseInt(numero));
                    numero = "";
                }
            }
        }
    
        int soma = 0;
        for (Integer numeros : pilha) { //Soma todos os numeros na pilha
            soma += numeros;
        }
    
        System.out.println("Dinheiro total recuperado: R$" + soma);
        imprimirMapa();
    }

    public static void imprimirMapa() {
        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("- Gostaria de visualizar o mapa fornecido? (S/N): ");
        String resposta = in.nextLine();

        if(resposta.equalsIgnoreCase("S")){
        System.out.println("");
        System.out.println("+++ Mapa fornecido: ");
        System.out.println("Linhas: " + linhas + "      colunas: " + colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }else if(resposta.equalsIgnoreCase("N")){
        System.out.println("Obrigada por utilizar o programa:)");
    }
}
}