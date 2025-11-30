package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = SlingHttpServletRequest.class,
adapters =  TestModel.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TestModelImpl implements TestModel{
    private static final Logger logger = Logger.getLogger(TestModelImpl.class);

    @SlingObject
    Resource componentResource;

    @Override
    public List<Map<String, String>> getBookDetails() {
        List<Map<String, String>> multiplebookitems = new ArrayList<>();

            Resource listofitems = componentResource.getChild("bookdetails");
            logger.info(componentResource.getChild("bookdetails"));
            if(listofitems!=null){
                for(Resource books : listofitems.getChildren()){
                    Map<String,String> bookmap = new HashMap<>();
                    bookmap.put("bookname", books.getValueMap().get("bookname", String.class));
                    bookmap.put("writtenby", books.getValueMap().get("writtenby", String.class));
                    multiplebookitems.add(bookmap);
                }
            }
        return multiplebookitems;
    }
    
}
