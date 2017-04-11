package org.collegemanagment.cache.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.collegemanagment.cache.api.SimpleCache;
import org.collegemanagment.validations.InvalidRequestException;


/* Implements Cache operations */

/* Commons cache operations */

public class SimpleCacheImpl<K, V> implements SimpleCache<K, V>{
	
	
	 private Class<K> keyClass;
	 private Class<V> valueClass;

	 public SimpleCacheImpl(Class<K> keyClass, Class<V> valueClass) {
			this.keyClass = keyClass;
			this.valueClass = valueClass;
	 }

	
	public Object create(ConcurrentMap<K, V> entities, 
            			 K id, 
            			 V entity){
		
			if(!entities.containsKey(id)){
				entities.put((K) id, entity);
				return entity;
			}else{
				throw new CacheBadRequestException(valueClass.getSimpleName() + " ID " + id + " already exists");
			}
	}
	
	public Collection<V> getAll(ConcurrentMap<K, V> entities){
		
		Collection<V> entityCollection = new ArrayList<V>();
		
		if(entities!=null && !entities.isEmpty()){
			for (Map.Entry<K, V> entry : entities.entrySet()) {
					entityCollection.add(entry.getValue());
			}
				return entityCollection;
		}else{
			throw new CacheNotFoundException("There are not " + valueClass.getSimpleName() );
		}				
		
	}
	
	public V get(ConcurrentMap<K, V> entities, K id){
		
		if(entities!=null && entities.containsKey(id)){
			return entities.get(id);
		}else{
			throw new CacheNotFoundException(valueClass.getSimpleName() + " ID " + id + " not exists");
		}
		
	}
	
	public void delete(ConcurrentMap<K, V> entities, 
			 			K id){
		
		 if(entities!=null && entities.containsKey(id)){
			 	entities.remove(id);
		  }else{
	   			throw new CacheNotFoundException(valueClass.getSimpleName() + " ID " + id + " not exists");
	   	 }		
	}
	
	public Object update(ConcurrentMap<K, V> entities, 
						 K id, 
					     V entity){
	
		   if(entities!=null && entities.containsKey(id)){
			  
				entities.put((K) id, entity);
				return entity;
				
		   }else{
				throw new CacheBadRequestException(valueClass.getSimpleName() + " ID " + id + " not exists");
		   }
	}
	
	

}
