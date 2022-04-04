//package SpringServiceConfig.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//public class security extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 都是無狀態請求，不需要session，節省資源
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//        //關閉csrf跨站請求防禦
//        http.csrf().disable();
//        // 所有的請求必須登錄認證後才能訪問
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//    }
//}
