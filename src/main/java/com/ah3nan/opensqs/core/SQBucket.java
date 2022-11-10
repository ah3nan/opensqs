package com.ah3nan.opensqs.core;

import com.ah3nan.opensqs.core.queue.SQueue;
import com.ah3nan.opensqs.core.storage.inmemory.InMemoryStore;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SQBucket {
  private final InMemoryStore InMemoryStoreQueues;

  private static volatile SQBucket INSTANCE;

  public static SQBucket getInstance() {
      if(INSTANCE == null) {
        synchronized(SQBucket.class) {
          InMemoryStore inMemorySQueues = new InMemoryStore();
          INSTANCE = new SQBucket(inMemorySQueues);
        }
      }

    return INSTANCE;
  }
  private SQBucket(InMemoryStore inMemorySQueues) {
    InMemoryStoreQueues = inMemorySQueues;
  }

  public void addQueue(UUID uuid,SQueue SQueue)  {
    try {
      var serializedQueue = SQSerializer.serialize(SQueue);
      getInstance().InMemoryStoreQueues.put(uuid.toString(),serializedQueue);
    } catch (IOException ioException) {
      System.out.println(ioException.getCause().toString());
    }

  }

  public List<String> getQueues()  {

    return getInstance().InMemoryStoreQueues.getAllKeys();
  }

  public Optional<SQueue> getQueue(UUID uuid)  {
    var storedQueue = getInstance().InMemoryStoreQueues.get(uuid.toString());
    try {
      SQueue deserializedQueue = SQSerializer.deserialize(storedQueue);

      return Optional.ofNullable(deserializedQueue);

    } catch (IOException | ClassNotFoundException exception) {
      return Optional.empty();
    }
  }

  public void removeQueue(UUID uuid) {
    getInstance().InMemoryStoreQueues.delete(uuid.toString());

  }

  public void cleanQueues() {
    getInstance().InMemoryStoreQueues.clear();
  }

  public Integer queuesCount() {
    return getInstance().InMemoryStoreQueues.size();
  }
}
