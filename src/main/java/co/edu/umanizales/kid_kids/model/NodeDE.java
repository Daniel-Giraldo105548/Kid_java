package co.edu.umanizales.kid_kids.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeDE {
    private Kid data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Kid data) {
        this.data = data;
    }
}
