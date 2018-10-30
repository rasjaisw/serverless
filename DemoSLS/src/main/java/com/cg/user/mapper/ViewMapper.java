package com.cg.user.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * The mapper utility class for populating the data from view pojos to JAXB object and vice versa. Field names should be same else
 * custom configuration needs to be done to tell the mapper the name of the source and target fields
 */
@Component
public class ViewMapper extends ConfigurableMapper {
    /**
     * default constructor
     */
    public ViewMapper() {
    	super();
    }

    
}



