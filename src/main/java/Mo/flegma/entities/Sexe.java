package Mo.flegma.entities;

import lombok.Getter;

@Getter
public enum Sexe {
    MEN("MEN"),
    WOMAN("WOMAN");
    private String value;

    Sexe(String sexe){
        this.value = sexe;
    }
}
