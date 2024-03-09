package com.example.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
	@Autowired
	private WebSocketHandlerConfig webSocketHandlerConfig;
	
	@Autowired
	private CustomHandshakeInterceptor customHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	logger.info("config class");
    	System.out.println("Received message: ");
        registry.addHandler(webSocketHandlerConfig,"/websocket").setAllowedOrigins("*").addInterceptors(customHandshakeInterceptor);
    	//registry.addHandler(webSocketHandlerConfig,"/websocket").addInterceptors(customHandshakeInterceptor).setAllowedOrigins("*");
    }
    
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
    	ServletServerContainerFactoryBean container=new ServletServerContainerFactoryBean();
    	return container;
    }
}
