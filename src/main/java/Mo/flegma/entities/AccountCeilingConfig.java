package Mo.flegma.entities;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class AccountCeilingConfig {
    private static final Map<Type, Double> ceilings = new HashMap<>();

    static {
        ceilings.put(Type.ENTERPRISE, 100000000.0);
        ceilings.put(Type.EMPLOYEE, 80000000.0);
        ceilings.put(Type.STUDENT, 5000000.0);
    }

    public static double getCeiling(Type type){
        return ceilings.getOrDefault(type, 0.0);
    }
}
