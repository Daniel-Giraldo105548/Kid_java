package co.edu.umanizales.kid_kids.service;

import co.edu.umanizales.kid_kids.model.ListSE;
import co.edu.umanizales.kid_kids.model.Node;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListSEService {
    private ListSE listSE;

    @PostConstruct
    public void init(){
        listSE = new ListSE();
    }

    public Node showKids(){
        return listSE.getHead();
    }
}