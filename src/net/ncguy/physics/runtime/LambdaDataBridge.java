package net.ncguy.physics.runtime;

import java.util.function.Function;

/**
 * Created by Guy on 18/09/2016.
 */
public class LambdaDataBridge<T, U> extends DataBridge<T, U> {

    Function<T, U> tToU;
    Function<U, T> uToT;

    public LambdaDataBridge(Function<T, U> tToU, Function<U, T> uToT) {
        this.tToU = tToU;
        this.uToT = uToT;
    }

    @Override
    public U toU(T t) {
        return this.tToU.apply(t);
    }

    @Override
    public T toT(U u) {
        return this.uToT.apply(u);
    }
}
