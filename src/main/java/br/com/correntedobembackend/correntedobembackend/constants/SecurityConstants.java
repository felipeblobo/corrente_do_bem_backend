package br.com.correntedobembackend.correntedobembackend.constants;

public class SecurityConstants {
    public static final String HEADER_ATTRIBUTE = "Authorization";
    public static final String ATTRIBUTE_PREFIX = "Bearer ";
    public static final String[] NO_AUTH_LIST = {

            "/project",
            "/project/{\\d+}",
            "/cause",
            "/cause/{\\d+}",
            "/hability",
            "/hability/{\\d+}",
            "/institution",
            "/institution/{\\d+}",
            "/swagger-ui/{\\d+}",
            "/swagger-ui/",
            "/swagger-ui",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**"

    };
    public static final String[] AUTH_LIST = {
            // -- swagger ui
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",

    };
    public static final String TOKEN_PASSWORD = "b2180839-c619-43a7-b49b-7cb7cc5d2de1";
    public static final String HEADER_NAME = "Authorization";
    public static final int TOKEN_EXPIRATION =  100000 * 60 * 30;
}