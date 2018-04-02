package hello.concurrent;

import java.util.Arrays;

public class OneValueCache {
    private final Integer lastNumber ;
    private final Integer[] lastFactors;

    public OneValueCache(Integer i,Integer[] factors){
            lastNumber = i==null?null:i;
            lastFactors = factors==null?null:Arrays.copyOf(factors,factors.length);
    }

    public Integer[] getFactors(Integer i){
        if(lastNumber==null || !lastNumber.equals(i) ){
            return null;
        }else {
            return Arrays.copyOf(lastFactors,lastFactors.length);
        }
    }

    @Override
    public String toString() {
        return "OneValueCache{" +
                "lastNumber=" + lastNumber +
                ", lastFactors=" + Arrays.toString(lastFactors) +
                '}';
    }
}
