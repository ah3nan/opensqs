package com.ah3nan.opensqs.core.queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class SQueue implements Serializable {
  private String identifier;
  private String queueName;
  private String queueType;
  private final ConcurrentLinkedQueue<SQMessage> sqMessages = new ConcurrentLinkedQueue<>();
  private SQueueOption SQueueOption;

  public SQueue(SQueueOption sQueueOption) {
    SQueueOption = sQueueOption;
  }


  public Optional<SQMessage> addMessage(SQMessage sqMessage) {
    sqMessages.add(sqMessage);
    
    return Optional.of(sqMessage);
  }

  public Optional<SQMessage> pollMessage() {

    return Optional.ofNullable(sqMessages.poll());
  }
  public Optional<SQMessage> peekMessage() {

    return Optional.ofNullable(sqMessages.peek());
  }
  public List<SQMessage> getAllMessages() {
    return new ArrayList<>(sqMessages);
  }

  public SQueueOption updateQueueOptions() {

    return new SQueueOption();
  }
  public Integer messagesCount() {
    return  sqMessages.size();
  }
  public boolean IsEmpty() {
    return sqMessages.isEmpty();
  }
}
