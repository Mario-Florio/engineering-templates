package shared.contracts;

import shared.contracts.__utils__.ContractException;

public class Contracts {
    static final Boolean ENABLE_CONTRACTS = Boolean.parseBoolean(System.getenv("ENABLE_CONTRACTS"));
    static public void must(Boolean condition, String message) {
        if (ENABLE_CONTRACTS && !condition) {
            throw new ContractException("Precondition Exception: "+message);
        }
    }
    static public void uphold(Boolean condition, String message) {
        if (ENABLE_CONTRACTS && !condition) {
            throw new ContractException("Invariant Exception: "+message);
        }
    }
    static public void guarantee(Boolean condition, String message) {
        if (ENABLE_CONTRACTS && !condition) {
            throw new ContractException("Postcondition Exception: "+message);
        }
    }
}
