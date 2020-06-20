package com.kuartz.auth.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("kuartz.auth")
public class AuthzProperties {

    private Map<String, ClientProperty> clients;

    private KeyStoreProperty keyStore;

    private GrandTypesProperty grandTypes;

    private int accessTokenValiditySeconds = 3600;
    private int refreshTokenValiditySeconds = 3600;

    private ClientDetailServiceType detailServiceType;

    public static class GrandTypesProperty {
        private String password;

        private String authorizationCode;

        private String refreshToken;

        private String implicit;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAuthorizationCode() {
            return authorizationCode;
        }

        public void setAuthorizationCode(String authorizationCode) {
            this.authorizationCode = authorizationCode;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getImplicit() {
            return implicit;
        }

        public void setImplicit(String implicit) {
            this.implicit = implicit;
        }
    }

    public static class ClientProperty {
        private String id;

        private String password;

        private List<String> scopes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<String> getScopes() {
            return scopes;
        }

        public void setScopes(List<String> scopes) {
            this.scopes = scopes;
        }

    }

    public static class KeyStoreProperty {
        private String filePath;

        private Resource filePathResource;

        private String filePassword;

        private String alias;

        private String password;

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public Resource getFilePathResource() {
            return filePathResource;
        }

        public void setFilePathResource(Resource filePathResource) {
            this.filePathResource = filePathResource;
        }

        public String getFilePassword() {
            return filePassword;
        }

        public void setFilePassword(String filePassword) {
            this.filePassword = filePassword;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public enum ClientDetailServiceType {
        IN_MEMORY,
        JDBC,
        REDIS
    }

    public Map<String, ClientProperty> getClients() {
        return clients;
    }

    public void setClients(Map<String, ClientProperty> clients) {
        this.clients = clients;
    }

    public KeyStoreProperty getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(KeyStoreProperty keyStore) {
        this.keyStore = keyStore;
    }

    public GrandTypesProperty getGrandTypes() {
        return grandTypes;
    }

    public void setGrandTypes(GrandTypesProperty grandTypes) {
        this.grandTypes = grandTypes;
    }


    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public int getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public ClientDetailServiceType getDetailServiceType() {
        return detailServiceType;
    }

    public void setDetailServiceType(ClientDetailServiceType detailServiceType) {
        this.detailServiceType = detailServiceType;
    }
}
