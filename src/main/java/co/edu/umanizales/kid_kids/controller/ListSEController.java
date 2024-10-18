package co.edu.umanizales.kid_kids.controller;

import co.edu.umanizales.kid_kids.model.Kid;
import co.edu.umanizales.kid_kids.model.Node;
import co.edu.umanizales.kid_kids.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public Node getListChildren(){
        return listSEService.showKids();
    }

    @PostMapping("/add")
    public String addKidToFinal(@RequestBody  Kid kid){
        listSEService.getListSE().add(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody  Kid kid){
        listSEService.getListSE().addToStart(kid);
        return "Adicionado al inicio exitosamente";
    }

    @PostMapping("/invert")
    public String invert(){
        return listSEService.getListSE().invert();
    }

    @PostMapping("/inposition/{position}")
    public String addInPosition(@RequestBody Kid kid, @PathVariable int position){
        // Validar
        if (position < 1 || position > listSEService.getListSE().getTalla()) {
            return "Posición no válida";
        }
        listSEService.getListSE().addInPosition(kid, position);
        return "Adicionado exitosamente";
    }

    @PostMapping("/deleteposition/{position}")
    public String deleteByPosition(@PathVariable int position) {
        if (position < 1 || position > listSEService.getListSE().getTalla()) {
            return "Posición no válida";
        }
        return listSEService.getListSE().deleteByPosition(position);
    }

    @PostMapping("/deleteid/{id}")
    public String deleteById(@PathVariable String id){
        return listSEService.getListSE().deleteById(id);
    }

    @PostMapping("/changextrenes")
    public String changeExtrenes(){
        return listSEService.getListSE().changeExtrenes();
    }

    @PostMapping("/gender")
    public String mixByGender(){
        return listSEService.getListSE().mixByGender();
    }

    @PostMapping("menorMayor")
    public String menorMayor(){
        listSEService.getListSE().menorMayor();
        return "Se menos mayor";
    }

    @PostMapping("/primerodamas")
    public String primeroMujer(){
        return listSEService.getListSE().primeroMujer();
    }

}
