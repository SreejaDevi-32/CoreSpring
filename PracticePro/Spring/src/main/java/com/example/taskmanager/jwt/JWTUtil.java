package com.example.taskmanager.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;


import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class JWTUtil {
	
	private static final String SECRET_KEY="foobar_123456789_foobar_123456789_foobar_123456789_foobar_123456789ajshDHWHD";
	
	public String issueToken(String subject,long expirationMs)
	{
		return issueToken(subject,Map.of(),expirationMs);
	}
	
	public String issueToken(String subject,long expirationMs,String ...scopes)
	{
		return issueToken(subject,Map.of("scopes",scopes),expirationMs);
	}
	
	public String issueToken(String subject,long expirationMs,List<String> scopes)
	{
		return issueToken(subject,Map.of("scopes",scopes),expirationMs);
	}
	
	public String issueToken(String subject,Map<String,Object> claims,long expirationMs)
	{
		String token =Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuer("")
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
		return token;
	}
	
	public String generateToken(String username, long expirationMs) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
	}
	
	public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

	public String getSubject(String token)
	{
		return getClaims(token).getSubject();
	
	}
	
	private Claims getClaims(String token)
	{
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims;
		
	}
	
	private Key getSigningKey() {
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public boolean isTokenValid(String jwt, String username)
	{
		String subject = getSubject(jwt);
		return subject.equals(username) && !isTokenExpired(jwt);
	}

	public boolean isTokenExpired(String jwt) {
		// TODO Auto-generated method stub
		Date today = Date.from(Instant.now());
		return getClaims(jwt).getExpiration().before(today);
	}

}
