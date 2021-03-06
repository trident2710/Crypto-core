/*
 * Copyright 2018 trident.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.trident.crypto.algo;

import com.trident.crypto.elliptic.EllipticCurvePoint;
import java.math.BigInteger;
import java.util.Objects;

/**
 * represents key pair in ECDSA
 * @author trident
 */
public class ECDSAKey {
    /**
     * secret key b -> random BigInteger
     */
    private final BigInteger keySec;
    
    /**
     * public key Q = b*G (product of generator point of elliptic curve and secret)
     */
    private final EllipticCurvePoint keyPub;

    public ECDSAKey(BigInteger keySec, EllipticCurvePoint keyPub) {
        this.keySec = keySec;
        this.keyPub = keyPub;
    }

    public BigInteger getKeySec() {
        return keySec;
    }

    public EllipticCurvePoint getKeyPub() {
        return keyPub;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Secret: ").append(keySec.toString(16)).append("\n");
        sb.append("Public: ").append(keyPub.getPointX().toString(16)).append(";").append(keyPub.getPointY().toString(16));
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.keySec);
        hash = 89 * hash + Objects.hashCode(this.keyPub);
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
        final ECDSAKey other = (ECDSAKey) obj;
        if (!Objects.equals(this.keySec, other.keySec)) {
            return false;
        }
        if (!Objects.equals(this.keyPub, other.keyPub)) {
            return false;
        }
        return true;
    }
    

    
}
