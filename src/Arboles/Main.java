package Arboles;

public class Main {
    public static void main(String[] args) {
        Arbol Tree = new Arbol();
        Tree.add(80);
        Tree.add(100);
        Tree.add(66);
        Tree.add(14);
        Tree.add(81);
        Tree.add(130);
        Tree.add(61);
        Tree.add(15);
        Tree.add(16);
        Tree.add(92);
        System.out.println(Tree.CantNodo());
        System.out.println(Tree.CantInc());
        System.out.println(Tree.Altura());
        System.out.println(Tree.Exists(66));
        System.out.println(Tree.Nivel(92));
        
        
        Arbol TreeV = new Arbol();
        System.out.println(TreeV.CantNodo());   
    }
}
