package co.edu.umanizales.kid_kids.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeABB {
    private Kid data;
    private NodeABB left;
    private NodeABB right;
    private int contador;
    private int altura;

    public NodeABB(Kid data) {
        this.data = data;
    }
}
