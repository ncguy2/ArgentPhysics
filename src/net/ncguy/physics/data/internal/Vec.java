package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public interface Vec<T> {

    T set(T vec);

    T add(T vec);
    T sub(T vec);
    T mul(T vec);

    T add(float f);
    T sub(float f);
    T scl(float f);

    float dst(T other);

    T mid(T vec);

    Vec cpy();

}
