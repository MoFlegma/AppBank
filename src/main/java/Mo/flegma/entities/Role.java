package Mo.flegma.entities;

import lombok.Getter;

@Getter
public enum Role {
    CLIENT("CLIENT"),
    ADMIN("ADMIN");

    private String value;

    Role(String role){
        this.value = role;
    }
}
