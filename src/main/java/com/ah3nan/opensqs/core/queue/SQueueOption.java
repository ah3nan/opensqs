package com.ah3nan.opensqs.core.queue;

import java.io.Serializable;

public class SQueueOption implements Serializable {
  private String  defaultVisibilityTimeout;
  private int defaultVisibilityTimeoutValue;
  private String messageRetentionPeriod;
  private int messageRetentionPeriodValue;
  private short maximumMessageSizeInKB;
  private String deliveryDelay;
  private int deliveryDelayValue;



}
