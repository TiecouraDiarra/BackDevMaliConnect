package com.Projet.Projet.Connaissances;

import com.Projet.Projet.utilisateur.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.Projet.Projet.Message.MessageResponse;
import com.Projet.Projet.utilisateur.User.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnaissancesImple implements ConnaissancesService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  ConnaissancesRepository connaissancesRepository;

    @Override
    public MessageResponse Supprimer(Long id_connaissances) {
        connaissancesRepository.deleteById(id_connaissances);
        return new MessageResponse("Type Supprime avec succes", true);
    }
    @Override
    public Connaissances Modifier(Connaissances connaissances) {
        return connaissancesRepository.findById(connaissances.getId())
                .map(p->{
                    p.setNom(connaissances.getNom());
                    p.setType(connaissances.getType());

                    return connaissancesRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("connaissence non trouvé !"));
    }
    @Override
    public List<Connaissances> Afficher() {
        return connaissancesRepository.findAll();
    }

    @Override
    public Object Ajouter(Connaissances connaissances) {
        // Obtenir l'utilisateur connecté à partir de l'objet Authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        // Obtenir l'utilisateur à partir de la base de données en fonction de l'username
        Optional<User> userOptional = userRepository.findByEmail(currentUsername);
        if (userOptional.isPresent()) {
//            connaissances.setUser(userOptional.get());
            connaissancesRepository.save(connaissances);
            return new MessageResponse("Ajouter avec succes", true);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Connaissance non trouvé", false));
        }
    }

    @Override
    public Connaissances ConnaissancesId(Long id_Connaissances) {
        return connaissancesRepository.findById(id_Connaissances).get();
    }

    @Override
    public MessageResponse modifierConnaissances(Long id, String nom, String type) {
        Connaissances connaissances = new Connaissances();
        connaissances.setId(id);
        connaissances.setNom(nom);
        connaissances.setType(type);

        Modifier(connaissances);

        return new MessageResponse("Connaissance  Modifie avec succes", true);
    }
}

