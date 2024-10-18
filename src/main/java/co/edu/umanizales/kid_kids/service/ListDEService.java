package co.edu.umanizales.kid_kids.service;

import co.edu.umanizales.kid_kids.model.ListDE;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ListDEService {
    private ListDE listDE;

    @PostConstruct
    public void init() {
        listDE = new ListDE();
    }

    public List showKids() {
        return listDE.show();
    }

}
