package com.rokwonk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rokwonk.dto.internal.JwtHeaderInfo;
import com.rokwonk.dto.response.AppleAuthKeysResponse;
import com.rokwonk.exception.inavlid.InvalidApplePublicKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class OpenIdVerifyService {
    private final int POSITIVE_SIGNUM = 1;

    private final ObjectMapper objectMapper;

    public PublicKey getApplePublicKey(String jwtHeader, AppleAuthKeysResponse authKeys) {
        try {
            JwtHeaderInfo jwtHeaderInfoObject = objectMapper.readValue(jwtHeader, JwtHeaderInfo.class);
            AppleAuthKeysResponse.Key publicKey = authKeys.getKeys().stream()
                    .filter(key -> key.getAlg().equals(jwtHeaderInfoObject.getAlg()))
                    .filter(key -> key.getKid().equals(jwtHeaderInfoObject.getKid()))
                    .findAny()
                    .orElseThrow();
            return createPublicKey(publicKey);
        } catch (JsonProcessingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new InvalidApplePublicKeyException();
        }
    }

    private PublicKey createPublicKey(AppleAuthKeysResponse.Key publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] n = Base64.getUrlDecoder().decode(publicKey.getN());
        byte[] e = Base64.getUrlDecoder().decode(publicKey.getE());
        RSAPublicKeySpec publicKeySpec =
                new RSAPublicKeySpec(new BigInteger(POSITIVE_SIGNUM, n), new BigInteger(POSITIVE_SIGNUM, e));

        KeyFactory keyFactory = KeyFactory.getInstance(publicKey.getKty());
        return keyFactory.generatePublic(publicKeySpec);
    }
}
