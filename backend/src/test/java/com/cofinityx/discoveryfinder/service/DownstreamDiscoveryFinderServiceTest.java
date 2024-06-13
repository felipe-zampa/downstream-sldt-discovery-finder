package com.cofinityx.discoveryfinder.service;

import org.eclipse.tractusx.discoveryfinder.repository.EndpointRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DownstreamDiscoveryFinderServiceTest {

    @Mock
    EndpointRepository repository;

    @InjectMocks
    DownstreamDiscoveryFinderService service;

    @Test
    @DisplayName("Given Downstream class has no implementation when delete method is invoked then there aren't interactions with repository")
    void deleteEndpoint() {
        service.deleteEndpoint(UUID.randomUUID().toString());
        verify(repository, times(0)).deleteById(any(UUID.class));
        verify(repository, times(0)).findEndpointByResourceId(anyString());
    }
}