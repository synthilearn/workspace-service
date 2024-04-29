package com.synthilearn.workspaceservice.infra.adapter.client;

import java.util.List;

import org.apache.http.HttpHeaders;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.synthilearn.commonstarter.GenericResponse;
import com.synthilearn.securestarter.AccessToken;
import com.synthilearn.workspaceservice.app.config.WebClientProperties;
import com.synthilearn.workspaceservice.infra.api.rest.dto.Workarea;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class WorkareaClient {

    private final WebClientProperties webClientProperties;
    private final WebClient webClient;

    public Mono<List<Workarea>> getAllWorkareas(AccessToken accessToken) {
        return webClient.get()
                .uri(webClientProperties.getWorkareaHost() + "/workarea/all")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken.getBody())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<GenericResponse<List<Workarea>>>() {
                })
                .map(GenericResponse::getResultData)
                .onErrorResume(error -> {
                    log.error("Error has occurred while get all workareas: {} {}", error, error);
                    GenericResponse<?> response =
                            ((WebClientResponseException) error).getResponseBodyAs(
                                    GenericResponse.class);
                    throw new RuntimeException(
                            response != null ? response.toString() : error.getMessage());
                });
    }

}
