package Arboles;

public class Arbol {
    private Nodo Raiz;
    private int n;
    
    public Arbol(){
        Raiz = null;
        n = 0;
    }
    
    public boolean isVacia(){
        return(Raiz == null);
    }
    
    public int CantNodo(){
        return n;
    }
    
    private boolean Hoja(Nodo T){ //funcion privada de la clase
        if(T == null)
            return false;
        if(T.getHI() == null && T.getHD() == null)
            return true;
        return false;
    }

    private int CantHijos(Nodo T){
        if(T.getHD() != null && T.getHI() != null)
            return 2;
        if((T.getHD() == null || T.getHI() == null)&&!(T.getHD() == null && T.getHI() == null))
            return 1;
        return 0;
    }
    
    public boolean Exists(int data){
        return exists(Raiz,data);
    }
    
    private boolean exists(Nodo T, int data){
        if(T == null)
            return false;
        
        if(T.getData() == data)
            return true;
        
        if(data > T.getData())
            return exists(T.getHD(),data);
        return exists(T.getHI(),data);
    }
    
    public void add(int newdata){
        if (isVacia()){
            Raiz = new Nodo(newdata);
            n++;
        }else{
            Nodo ant = null;
            Nodo p = Raiz;
            while (p!=null){
                if (newdata < p.getData()){
                    ant = p;
                    p = p.getHI();
                }else{
                    if (newdata > p.getData()){
                        ant = p;
                        p = p.getHD();
                    }else 
                        return; //en caso de que sea igual, no se efectua ningún cambio
                }
            } 
            Nodo newnodo = new Nodo(newdata);
            if(newdata > ant.getData()){
                ant.setHD(newnodo);
                n++;
            }else{
                ant.setHI(newnodo);
                n++;
            }     
        }
    }
    
    public int CantNodos(){
        return cnodos(Raiz);
    }
    
    private int cnodos(Nodo T){ //funcion privada de la clase
        if (isVacia())
            return 0;
        if (Hoja(T))
            return 1;
        else{
           return (cnodos(T.getHI()) + cnodos(T.getHD()) + 1);
        }
    }
    
    public int CantInc(){
        return cinc(Raiz);
    }
    
    private int cinc(Nodo T){
        if(T == null){
            return 0;
        }else{
            if(Hoja(T)){
                return 0;
            }else{
                int izq = cinc(T.getHI());
                int der = cinc(T.getHD());
                if(CantHijos(T) == 1)
                    return izq+der+1;
                else
                    return izq+der;
            }
        }
    }   
    
    public int Altura(){
        return(altura(Raiz));
    }
    
    private int altura(Nodo T){
        if(T == null)
            return 0;
        else{
            if(Hoja(T))
                return 1;
            else{
                int izq = altura(T.getHI());
                int der = altura(T.getHD());
                if (izq > der)
                    return izq + 1;
                return der + 1;
            }
        }
    }

    public int Nivel(int data){
        return nivel(Raiz, data);
    }
    
    private int nivel(Nodo T, int data){
        int nvl;
        if(T == null)
            return 0;
        if(Hoja(T)){
            if(T.getData() == data)
                return 1;
            return 0;
        }
        if(T.getData() == data)
            return 1;
        
        if(data > T.getData())
            nvl = nivel(T.getHD(),data);
        else
            nvl = nivel(T.getHI(),data);
        
        if (nvl == 0)
            return 0;
        
        return nvl + 1;
    }
}
