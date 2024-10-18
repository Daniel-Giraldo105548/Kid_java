package co.edu.umanizales.kid_kids.controller;

import co.edu.umanizales.kid_kids.model.Kid;
import co.edu.umanizales.kid_kids.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public List getListChildren(){
        return listDEService.showKids();
    }

    @PostMapping("/add")
    public String addKidToFinal(@RequestBody Kid kid){
        listDEService.getListDE().add(kid);
        return "Adicionado exitosamente";
    }

   @PostMapping("/tostart")
    public String addToStart(@RequestBody Kid kid){
        listDEService.getListDE().addToStart(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/addpositon/{position}")
   public String addInPosition(@RequestBody Kid kid, @PathVariable int position) {
        listDEService.getListDE().addInPosition(kid, position);
        return "Adicionado exitosamente";
    }



    @PostMapping("/deleteposition/{position}")
    public String deleteByPosition(@PathVariable int position) {
        if (position < 1 || position > listDEService.getListDE().getSize()) {
            return "Posición no válida";
        }
        listDEService.getListDE().deleteByPosition(position);
        return "Se borro";

    }

    @PostMapping("/deleteid/{id}")
    public String deleteById(@PathVariable String id){
        return listDEService.getListDE().deleteById(id);
    }

    @PostMapping("/invert")
    public String invert(){
        return listDEService.getListDE().invert();
    }

    @PostMapping("/changeextremes")
    public String changeExtremes(){
       return listDEService.getListDE().changeExtrenes();
    }

    @PostMapping("/switchgender")
    public String switchByGender(){
        listDEService.getListDE().switchByGender();
        return "Mezclado por genero";
    }


}
