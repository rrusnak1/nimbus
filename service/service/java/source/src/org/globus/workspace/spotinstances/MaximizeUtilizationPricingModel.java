package org.globus.workspace.spotinstances;

import java.util.Collection;
import java.util.LinkedList;

import edu.emory.mathcs.backport.java.util.Collections;

public class MaximizeUtilizationPricingModel extends AbstractPricingModel {

    private boolean setMinPrice;

    public MaximizeUtilizationPricingModel(){
        this(true);
    }    
    
    public MaximizeUtilizationPricingModel(boolean setMinPrice){
        this.setMinPrice = setMinPrice;
    }
    
    @Override
    protected Double getNextPriceImpl(Integer totalReservedResources,
            Collection<SIRequest> requests, Double currentPrice) {
       
        LinkedList<SIRequest> reverseOrderedRequests = new LinkedList<SIRequest>(requests);
        Collections.sort(reverseOrderedRequests, Collections.reverseOrder());
        
        Double nextPrice = PricingModelConstants.MINIMUM_PRICE;
        Integer availableResources = totalReservedResources;
        
        for (SIRequest siRequest : reverseOrderedRequests) {
            if(siRequest.getMaxBid() >= PricingModelConstants.MINIMUM_PRICE){
                nextPrice = siRequest.getMaxBid();
                availableResources -= siRequest.getNeededInstances();
                if(availableResources <= 0){
                    break;
                }
            }
        }
        
        if(availableResources > 0 && this.setMinPrice){
            nextPrice = PricingModelConstants.MINIMUM_PRICE;
        }
        
        return nextPrice;
    }


}