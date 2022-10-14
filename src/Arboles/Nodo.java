package Arboles;

public class Nodo {
    private int data;
    private Nodo HI;
    private Nodo HD;
    
    //constructor sin parámettros
    public Nodo(){
        this.data = 0;
        this.HD = null;
        this.HI = null;
    }
    
    //constructor parametrizado
    public Nodo(int data){
        this.data = data;
        this.HD = null;
        this.HI = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Nodo getHI() {
        return HI;
    }

    public void setHI(Nodo HI) {
        this.HI = HI;
    }

    public Nodo getHD() {
        return HD;
    }

    public void setHD(Nodo HD) {
        this.HD = HD;
    }
}
