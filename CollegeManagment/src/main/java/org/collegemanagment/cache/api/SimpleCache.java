package org.collegemanagment.cache.api;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

public interface SimpleCache<K, V> {
	
	Object create(ConcurrentMap<K, V> entities,K id,V entity);
	
	Collection<V> getAll(ConcurrentMap<K, V> entities);
	
	void delete(ConcurrentMap<K, V> entities,K id);
	
	Object update(ConcurrentMap<K, V> entities, K id, V entity);

}
