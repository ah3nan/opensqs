package com.ah3nan.opensqs.core.storage.inmemory;

import com.ah3nan.opensqs.core.storage.KeyValue;
import com.ah3nan.opensqs.core.storage.KeyValueStore;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryStore implements KeyValueStore<String,byte[]> {
  private final Map<String,byte[]> map = new ConcurrentHashMap<>() {
  };
  public void init () {

  }
  @Override
  public void putAll(List<KeyValue<String, byte[]>> entries) {

   entries.forEach(v -> put(v.key, v.value));
  }
  public List<String> getAllKeys() {
   return new ArrayList<>(map.keySet());
  }
  @Override
  public void put(String key, byte[] value) {
    map.put(key, value);
  }

  @Override
  public byte[] putIfAbsent(String key, byte[] value) {

    return map.putIfAbsent(key, value);
  }

  @Override
  public byte[] get(String key) {
    return map.get(key);
  }

  @Override
  public byte[] delete(String key) {

    return map.remove(key);
  }

  public void clear() {
    map.clear();
  }

  public Integer size() {
    return map.size();
  }

}
