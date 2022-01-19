package com.personal.apisecjdk8.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.personal.apisecjdk8.model.dto.UserAuthDTO;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Interface a ser implementada pelos TokenProviders a serem usados na aplicação
 * 
 * @param <T>
 */
public interface AbstractTokenProvider<T> {

	/**
	 * Declaração de data
	 * 
	 * @throws JsonProcessingException
	 * @throws JWTCreationException
	 * @throws IllegalArgumentException
	 */
	String createToken(T data, UserAuthDTO userAuthDTO, String sytem, Integer userProfile);

	/**
	 * Método padrão de verificação de validade de token
	 * 
	 * @param authToken
	 * @param secretKey
	 * @return
	 */
	default boolean validateToken(String authToken, String secretKey) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException e) {
			LogHolder.LOG.info("Invalid JWT signature.");
			LogHolder.LOG.trace("Invalid JWT signature trace: {}", e);
		} catch (IllegalArgumentException e) {
			LogHolder.LOG.info("JWT token compact of handler are invalid.");
			LogHolder.LOG.trace("JWT token compact of handler are invalid trace: {}", e);
		}
		return false;
	}

	/**
	 * Método que retorna dados recuperados do token
	 * 
	 * @param token
	 * @return
	 */
	T getData(String token);

	/**
	 * Método que inicializa variável
	 */
	final class LogHolder {

		/**
		 * Construtor do método
		 */
		private LogHolder() {
		}

		/**
		 * Definição de log do tipo Logger
		 */
		static final Logger LOG = LoggerFactory.getLogger(AbstractTokenProvider.class);
	}

	/**
	 * Método que inicializa variáveis do TokenProvider
	 */
	void init();

}
