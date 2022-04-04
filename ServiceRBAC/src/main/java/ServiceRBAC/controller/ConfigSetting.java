package ServiceRBAC.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConfigSetting {

    @Value("${github.test}")
    private String configGit;

    public String getConfigGit() {
        return configGit;
    }
}
