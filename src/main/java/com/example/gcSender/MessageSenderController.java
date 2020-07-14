package com.example.gcSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MessageSenderController {

    @Autowired
    private PubsubOutboundGateway messagingGateway;

    @PostMapping("/postMessage")
    public RedirectView postMessage(@RequestParam("message") String message) {
        this.messagingGateway.sendToPubSub(message);
        return new RedirectView("/");
    }


}
