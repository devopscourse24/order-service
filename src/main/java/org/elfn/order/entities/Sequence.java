package org.elfn.order.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** Classe représentant une séquence pour générer des identifiants uniques dans une collection MongoDB. */

@Document(collection = "sequence")
public class Sequence {
    @Id
    private String id;
    private int sequence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
