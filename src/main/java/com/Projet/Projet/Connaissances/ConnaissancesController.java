package com.Projet.Projet.Connaissances;

import com.Projet.Projet.Message.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("api/connaissance")
public class ConnaissancesController {

    @Autowired
    private ConnaissancesService connaissancesService;

    @GetMapping("/afficher")
    public List<Connaissances> Afficher(){
        return connaissancesService.Afficher();
    }

    //AJOUTER Une connaissance
    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ajouter")
    public Object Ajouter (@RequestBody Connaissances connaissances) throws IOException {
        return connaissancesService.Ajouter(connaissances);
    }

    //MODIFIER UNE EXPERIENCE
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modifier")
    public MessageResponse modifier(@RequestBody Connaissances connaissances) {
        connaissancesService.Modifier(connaissances);
        return new MessageResponse("Connaissance  Modifie avec succes", true);
    }

    //SUPPRIMER UNE EXPERIENCE PROFESSIONELLE
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/supprimer/{id_connaissances}")
    public MessageResponse Supprimer(@PathVariable("id_econnaissances") Long id_connaissances){
        return connaissancesService.Supprimer(id_connaissances);
    }
}