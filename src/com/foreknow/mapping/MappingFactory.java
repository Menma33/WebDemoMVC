package com.foreknow.mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类
 * 作用是用来管理XXXMapping对象的
 */
public class MappingFactory {
    private static MappingFactory mappingFactory = null;
    private Map<String, EntityMapping> maps = new HashMap<>();
    public static final String GUESTBOOK_MAPPING = "questbookmapping";
    public static final String ADMIN_MAPPING = "adminmapping";

    private MappingFactory() {

    }

    public static MappingFactory getInstance() {
        if (mappingFactory == null) {
            mappingFactory=new MappingFactory();
            mappingFactory.maps.put(GUESTBOOK_MAPPING, new GuestbookMapping());
            mappingFactory.maps.put(ADMIN_MAPPING,new AdminMapping());
        }
        return mappingFactory;
    }
    public EntityMapping getMap(String key){
        return maps.get(key);
    }
}
