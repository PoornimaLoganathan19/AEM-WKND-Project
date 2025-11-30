package com.adobe.aem.guides.wknd.core.models;

import java.util.List;
/**
 * This interface exposes the value of the byline component.
 */
public interface Byline {
    
    String getName();

    List<String> getOccupations();

    boolean isEmpty();
}
