package Mo.flegma.exception;

import java.util.UUID;

public class ClassNotFoundException extends RuntimeException{
    public ClassNotFoundException(UUID id, String className ){
        super("Could not find" + className + "with id" + id);
    }
}
