package org.elfn.order.services;

import org.elfn.order.dtos.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RestService {

     final RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Méthode privée pour récupérer les détails d'un utilisateur à partir de son ID.
    public User fetchUserDetailsFromUserId(Integer userId) {
        // Utilise RestTemplate pour envoyer une requête HTTP GET et récupérer les détails de l'utilisateur.
        return restTemplate.getForObject(
                "http://USER-SERVICE/user/fetchUserById/" + userId,  // URL du service avec l'ID de l'utilisateur
                User.class);  // Classe de l'objet attendu en réponse
    }

}
