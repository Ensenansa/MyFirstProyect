/*
 * The MIT License
 *
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package edu.eci.arsw.cartmode.model.impl;

import java.util.Objects;

/**
 *
 * @author dbeltran
 */
public class Tripla<T1, T2, T3> {
    
    T1 o1;
    T2 o2;
    T3 o3;
    
    public Tripla(T1 o1, T2 o2, T3 o3) {
        super();
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
    }

    public T1 getElem1() {
        return o1;
    }

    public T2 getElem2() {
        return o2;
    }
    
    public T3 getElem3() {
        return o3;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        hash = 17 * hash + Objects.hashCode(this.o3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tripla<?, ?, ?> other = (Tripla<?, ?, ?>) obj;
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        if (!Objects.equals(this.o2, other.o2)) {
            return false;
        }
        if (!Objects.equals(this.o3, other.o3)) {
            return false;
        }
        return true;
    }
}
