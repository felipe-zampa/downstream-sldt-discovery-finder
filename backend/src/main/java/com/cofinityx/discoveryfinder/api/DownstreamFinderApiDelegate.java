package com.cofinityx.discoveryfinder.api;

import org.eclipse.tractusx.discoveryfinder.api.FinderApiDelegate;
import org.eclipse.tractusx.discoveryfinder.service.DiscoveryFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("downstreamDelegate")
public class DownstreamFinderApiDelegate implements FinderApiDelegate {

    //if we need to implement a different Service version the same strategy can be applied here
    // DownstreamService implements DiscoveryFinderService
    private DiscoveryFinderService discoveryFinderService;

    public DownstreamFinderApiDelegate(@Autowired @Qualifier("downstreamService") DiscoveryFinderService discoveryFinderService){
        this.discoveryFinderService = discoveryFinderService;
    }

    @Override
    public ResponseEntity<Void> deleteDiscoveryEndpointByResourceId(String resourceId) {
        discoveryFinderService.deleteEndpoint( resourceId );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}