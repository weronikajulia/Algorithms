package pl.edu.pw.ee.aisd2023zlab2;

public class HashListChainingMultiplicativeHashing <T extends Comparable<T>> extends HashListChaining<T>  {

    public HashListChainingMultiplicativeHashing() {
        super();
    }

    public HashListChainingMultiplicativeHashing(int size) {
        super(size);
    }
    public double A = ((Math.sqrt(5)-1)/2);
    @Override
    int countHashId(T value) {
        int hashCode = value.hashCode() & Integer.MAX_VALUE;
        return (int)(((hashCode * A) % 1) *size);
    }
}
