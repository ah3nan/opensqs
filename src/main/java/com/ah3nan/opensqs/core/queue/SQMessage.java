package com.ah3nan.opensqs.core.queue;

import java.io.Serializable;

public class SQMessage implements Serializable {
  private String  identifier;
  private String body;
  private SQMessageState SQMessageState;

  public SQMessage() {
  }


}
