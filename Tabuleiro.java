import java.util.*;
public class Tabuleiro {
    protected Setor[][] tabuleiro;
    protected char[] representacaoGrafica;
    
    /* 0-simples 1-suporte */
    protected Player[] ps;
    
    Tabuleiro(Player[] ps) {
        this.ps = new Player[2];
        this.ps = ps;
        this.tabuleiro = new Setor[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.tabuleiro[i][j] = new Setor(i, j);
            }
        }

        this.tabuleiro[2][2].setTipo(3);
        this.tabuleiro[2][2].setPassou(false);
        
        Random gerador = new Random();
        int x = gerador.nextInt(5);
        int y = gerador.nextInt(5);
        while (x == 2 && y == 2){
            x = gerador.nextInt(5);
            y = gerador.nextInt(5);
        }
        this.tabuleiro[x][y].setTipo(4);

        this.setRepresentacaoGrafica();
    }

    public Setor getSetor(int i, int j){
        return this.tabuleiro[i][j];
    }


    public void setRepresentacaoGrafica(){
    String tmp = "";
    for(int i = 0; i < 11; i++){
        for(int j = 0; j < 21; j++){
            if(j % 4 == 0)
                tmp = tmp.concat("|");
            else if(i % 2 == 0)
                tmp = tmp.concat("-");
            else
                tmp = tmp.concat(" ");
        }
        tmp = tmp.concat("\n");
    }
    this.representacaoGrafica = tmp.toCharArray();
    this.representacaoGrafica[6*21+6+10]= '*';
    this.representacaoGrafica[4*21+4+10]= '*';
    this.representacaoGrafica[5*21+5+8]= '*';
    this.representacaoGrafica[5*21+5+10]= 'C';
    this.representacaoGrafica[5*21+5+12]= '*';
    }

    
    public void atualizarTabela(int i, int j, Player P){
        int x = 1 + 2 * i;
        int y = 2 + 4 * j, idx = 0;

        idx = x * 21 + x + y;
        if(!(i == 2 && j == 2)){
            if(this.getSetor(i, j).getPlayers() == 2)
                this.representacaoGrafica[idx] = 'P';
            else if(P instanceof PlayerSimples)
                this.representacaoGrafica[idx] = '1';
            else
                this.representacaoGrafica[idx] = '2';
            }

        if(this.tabuleiro[i][j].getCima()){
            idx = (x - 1) * 21 + (x - 1) + y;
            this.representacaoGrafica[idx] = '*';
        }
        if(this.tabuleiro[i][j].getEsq()){
            idx = x * 21 + x + y - 2;
            this.representacaoGrafica[idx] = '*';
        }
        if(this.tabuleiro[i][j].getBaixo()){
            idx = (x + 1) * 21 + (x + 1) + y;
            this.representacaoGrafica[idx] = '*';
        }
        if(this.tabuleiro[i][j].getDir()){
            idx = x * 21 + x + y + 2;
            this.representacaoGrafica[idx] = '*';
        }
    }

    public void apagarRastro(int i, int j){
        int x = 1 + 2 * i;
        int y = 2 + 4 * j;
        if(!(i == 2 && j == 2)){
            this.representacaoGrafica[x * 21 + x + y] = ' ';
        }
    }

    public void apagarRastro(int i, int j, Player P){
        int x = 1 + 2 * i;
        int y = 2 + 4 * j;
        if(!(i == 2 && j == 2)){
            if (P instanceof PlayerSimples)
                this.representacaoGrafica[x * 21 + x + y] = '2';
            else
                this.representacaoGrafica[x * 21 + x + y] = '1';
        }
    }

    public void desenhar(){
        System.out.println(this.representacaoGrafica);
    }

    public void jogar(Setor setor, Player P, Scanner sc, Banner banner){
        System.out.println("Escolha uma opcao:");
        System.out.println("1- Atacar");
        int opcao = 2;
        
        if (setor.getTipo() != 2){
            System.out.println(opcao + "- Procurar");
            opcao++;
        }
        if(P instanceof PlayerSuporte){
            System.out.println(opcao + "- Recuperar defesa");
        }

        String tmp = sc.next();
        boolean flag = true;
        
        while(flag){
            if(tmp.compareTo("1") == 0){
                P.atacar();
                flag = false;
            }else if(setor.getTipo() == 0 && tmp.compareTo("2") == 0){
                P.procurar();
                flag = false;
            }else if(P instanceof PlayerSuporte && tmp.compareTo("2") == 0){
                PlayerSuporte Ptmp = (PlayerSuporte) P;
                Ptmp.recuperarDefesa(ps, sc, banner);
                flag = false;
            }else if(tmp.compareTo("3") == 0){
                PlayerSuporte Ptmp = (PlayerSuporte) P;
                Ptmp.recuperarDefesa(ps, sc, banner);
                flag = false;
            }else{
                flag = true;
                System.out.println("Opcao inválida, escolha novamente.");
                sc.reset();
                sc.next();
            }
        }  
    
    
    
    }
}