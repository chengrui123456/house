package com.cr.house.config;

import com.cr.house.security.AuthFilter;
import com.cr.house.security.AuthProvider;
import com.cr.house.security.LoginAuthFailHander;
import com.cr.house.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;


@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    /**
     * Http权限控制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);//手机验证登录
        //资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll()//管理员登录入口
                .antMatchers("/static/**").permitAll()//静态资源
                .antMatchers("/user/login").permitAll()//用户登录入口
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")//配置之角色登录处理入口
                .failureHandler(authFailHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");
        http.csrf().disable();//关闭跨域请求伪造csrf
        http.headers().frameOptions().sameOrigin();//因为h-ui，同源
    }
    /**
     * 自定义认证策略
     * @throws Exception
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) {
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and();
        auth.authenticationProvider(authProvider()).eraseCredentials(true);//清除密码
    }

    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint() {
        return new LoginUrlEntryPoint("/user/login");
    }

    @Bean
    public LoginAuthFailHander authFailHandler() {
        return new LoginAuthFailHander(urlEntryPoint());
    }


    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager =  super.authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManager;
    }

    @Bean
    public AuthFilter authFilter() {
        AuthFilter authFilter = new AuthFilter();
        authFilter.setAuthenticationManager(authenticationManager());
        authFilter.setAuthenticationFailureHandler(authFailHandler());
        return authFilter;
    }
}
