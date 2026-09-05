package com.panha.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.GrantedAuthority;



import java.util.Collection;

public class JwtConstant {

    public static final String SECRET_KEY
             = "ad902d11e0df5ce3a403ca7ae9bbbc00fd5a19ad91dee06aaa201b8bda170d68";

    public static final String TOKEN_PREFIX = "Bearer";

}
