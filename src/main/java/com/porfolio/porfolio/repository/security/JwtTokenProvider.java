/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.security;

import com.porfolio.porfolio.repository.exception.porfolioException;
import io.jsonwebtoken.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dante
 */
@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generarToken(Authentication authentication) {
        String username = authentication.getName();
        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);

        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

        return token;
    }

    public String obtenerUsernameDelJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String refreshToken(String token) {

        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Date fechaExpiracion = claims.getExpiration();
        String username = this.obtenerUsernameDelJWT(token);
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

    }

    public boolean validarToken(String token) {
        boolean flag = false;
        try {
            Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token);
            flag = true;
        } catch (SignatureException e) {
            throw new porfolioException(HttpStatus.BAD_REQUEST, "Firma de token no valida");
        } catch (MalformedJwtException e) {
            throw new porfolioException(HttpStatus.BAD_REQUEST, "Token  no valido");
        } catch (ExpiredJwtException e) {
            throw new porfolioException(HttpStatus.BAD_REQUEST, "Token  caducado");
        } catch (UnsupportedJwtException e) {
            throw new porfolioException(HttpStatus.BAD_REQUEST, "Token no compatible");
        } catch (IllegalArgumentException e) {
            throw new porfolioException(HttpStatus.BAD_REQUEST, "La cadena claims esta vacia");
        }
        return flag;
    }
}
