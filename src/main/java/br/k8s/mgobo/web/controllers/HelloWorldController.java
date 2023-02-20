package br.k8s.mgobo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/hello")
@RequiredArgsConstructor
public class HelloWorldController implements Serializable {

    private static final String HOST_NAME = "HOSTNAME";
    private static final String DEFAULT_ENV_INSTANCE_GUID = "LOCAL";
    @Value("${" + HOST_NAME + ":" + DEFAULT_ENV_INSTANCE_GUID + "}")
    private String hostName;

    public String retrieveInstanceInfo() {
        return hostName.substring(hostName.length() - 5);
    }

    @GetMapping
    public String helloWorld() {
        return String.format("Hello Java from GKS, INSTANCE %s....", (this.retrieveInstanceInfo()));
    }

    @GetMapping("/health")
    public String imHealthy() {
        return "{healthy:true}";
    }

    @GetMapping("/ingress")
    public String ingress() {
        return "Ingress is working...!";
    }
}
