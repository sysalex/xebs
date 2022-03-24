package cc.alex.xebs.properties;

import lombok.Data;

/**
 * @author alex-dx
 */
@Data
public class XebsClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
