public class PlayerSimples extends Player{
    
    PlayerSimples(){
        super();
        this.setAtk();
        this.setDef();
    }

    public void setAtk(){
        this.atk = 2;
    }

    public void setDef(){
        this.def = 6;
    }
}