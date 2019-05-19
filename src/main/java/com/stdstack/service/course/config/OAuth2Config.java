package com.stdstack.service.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 */
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    private String clientid = "std_stack";

    private String clientSecret = "my-secret-key";

    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n"
            + "MIIEpAIBAAKCAQEAow5XWG/tL24xYOj5oGVYmOP6vlvrfepGr2AexXABw1H8gkx4\n"
            + "D/pwPpDZY3l2DgvlQmPiF2A+6kR6tXpes4V9ZjXvSgWblveG0JdVs3IlSrMDY5ff\n"
            + "eM3au9AuqBeyQ+X/br5uK7dEKB++EQijWh0tgiuoATDsYP6xkZiQwDHfwI3guLm1\n"
            + "+xAWtgsWnwc+gFvJSbkQlf1SZUpCtaWRHoVVHpSY3yriWrHBefWESz1Aax9q5AvQ\n"
            + "B1TjMUVqHtZaFT7M/sIXYD+nSNfdOnPQEQHBYIdzo7ORGRiMltBc+2aeSgmC32yd\n"
            + "I/EC4EX5XDeNcqPLJFByOhDYRZSOvdxj+liCmQIDAQABAoIBAQCHOGRtHdz3wY1H\n"
            + "jc0+G+2+VQnjBX2knT1jQPYjzABaR0p9kAbdUVX2PM9a9CZX/btxND4SHqnuQz3z\n"
            + "8/hHLkPRGJdJrp7aMonlwCq9NsMAULZVyGP13dkwebPHiGc4catD3r6kmEX4dGJ9\n"
            + "48j7+Uh9M9EOs9DDm1QMpxYbnQCuwGbE5rhxobPt01zYBgkOrpenwCJgtIaS2kmF\n"
            + "LrboPSQ9OXTI5FGkaveyzEhhG7eX9uVSsFspQNqWZkm6j8gEMVl0XnjVe7eL2x0h\n"
            + "5vaheBaLEmAyFFHaGnfhrUsw8khFnFbyo4OcSq75U1sAUtsLgd2agFwsOm2qtIQ0\n"
            + "lr78rl7RAoGBANZDS9zw0aw/J3w1itomFgS3SWXuzsBUItsBylLPYOIk2KWicJHG\n"
            + "hUMo1muX4oFnQQ94ox+8U8Bz6Ov9c4SC3ZZKDQuFId+M5zepCfSyXwmyR9YhMU1y\n"
            + "Xu0qyeOHXfbdyElXNkbs+AlTzDGnsX5zwq5mWu/BOaxN38RlOryK+nkFAoGBAMLR\n"
            + "f72Yndk9HHZ2E7z7oVIBq77w6aS6OKg7P4VATMzMl5T2swVM0IsLkvIILCABoP6k\n"
            + "jROPRU3LmxeKc5rbqSyxcEjP5gUB+W53hUJIbr53qnsz2pZfHOgPDXcSzADPik/S\n"
            + "QYb7Ov9vwpq/M9y07suQIfjBF/n9nxmT4LjjroeFAoGAbsCScj4442QxsM6sW17c\n"
            + "esuTMRFj5Z6X9cTTJEL1vW92XQe+UFvhfnmZfDwiZOlOhATDrR/X2t8PQwzbrV9H\n"
            + "0uusGoxSmg9nZSoHb2jUH1r8Lv8xUOsRjl5TxTyvoW+6m85sy/SpsYiTQAeCg+6q\n"
            + "byORVeT3Ps1yIT6CQftExVECgYAtgJcQZnP/yFk8hemoSzFroP5HM6eulNwk1unI\n"
            + "KrOFZgfFgDVh+IYA4+wnYadEtnyu3SoiNmVefT61Kd5EfieuS6dJKl20L7jdh0b1\n"
            + "q0tKa1LDQeI9Guv6e4GOnTJOwiqw6A/sAgPOo4DVefEYDJ51py14F0mNVyJw6+wh\n"
            + "4vPhrQKBgQCW6DF4CdbIyCEYuv0sW4FjKZui1zqaJy+IXHZusEJVA8JMC7wEhiow\n"
            + "uK4Fs7J67ppkUJ1PDSEYMm6ywU+fwT1x7+M1OcS9r1eD2+vSK91FxjUNna69Shyc\n"
            + "XiXNtxDo7xIY+UfKHPjAw704Xww4AQYSLbPkUvlgRWAdrbTLBFtWTg==\n"
            + "-----END RSA PRIVATE KEY-----";

    private String publicKey = "-----BEGIN PUBLIC KEY-----\n"
            + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAow5XWG/tL24xYOj5oGVY\n"
            + "mOP6vlvrfepGr2AexXABw1H8gkx4D/pwPpDZY3l2DgvlQmPiF2A+6kR6tXpes4V9\n"
            + "ZjXvSgWblveG0JdVs3IlSrMDY5ffeM3au9AuqBeyQ+X/br5uK7dEKB++EQijWh0t\n"
            + "giuoATDsYP6xkZiQwDHfwI3guLm1+xAWtgsWnwc+gFvJSbkQlf1SZUpCtaWRHoVV\n"
            + "HpSY3yriWrHBefWESz1Aax9q5AvQB1TjMUVqHtZaFT7M/sIXYD+nSNfdOnPQEQHB\n"
            + "YIdzo7ORGRiMltBc+2aeSgmC32ydI/EC4EX5XDeNcqPLJFByOhDYRZSOvdxj+liC\n"
            + "mQIDAQAB\n"
            + "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                 .tokenStore(tokenStore())
                 .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient(clientid)
               .secret(encoder.encode(clientSecret))
               .scopes("read", "write")
               .authorizedGrantTypes("password", "authorization_code", "refresh_token")
               .accessTokenValiditySeconds(20000)
               .refreshTokenValiditySeconds(20000);

    }
}