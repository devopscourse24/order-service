package org.elfn.order.services;

import org.elfn.order.entities.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Service pour générer des identifiants de commande séquentiels en utilisant une séquence stockée dans MongoDB.
 */
@Service
public class SequenceGenerator {
    private final MongoOperations mongoOperations; // Injection de la dépendance pour les opérations MongoDB.

    public SequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int generateNextOrderId() {
        // Trouve et modifie l'entrée de la séquence dans la base de données pour incrémenter la séquence.
        Sequence counter = mongoOperations.findAndModify(
                query(where("_id").is("sequence")), // Requête pour trouver l'entrée avec l'id "sequence".
                new Update().inc("sequence", 1), // Incrémente la valeur de 'sequence' de 1.
                options().returnNew(true).upsert(true), // Retourne la nouvelle valeur et crée si cela n'existe pas.
                Sequence.class); // La classe du document à retourner.
        return counter.getSequence(); // Renvoie la nouvelle valeur de la séquence.
    }
}

