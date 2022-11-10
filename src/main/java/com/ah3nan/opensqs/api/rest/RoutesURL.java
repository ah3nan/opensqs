package com.ah3nan.opensqs.api.rest;

public enum RoutesURL {
  GET_BUCKET_QUEUES("/api/v1/queues"),
  GET_QUEUE("/api/v1/queue"),
  POST_QUEUE("/api/v1/queue"),
  PATCH_QUEUE("/api/v1/queue"),
  DELETE_QUEUE("/api/v1/queue"),
  CLEAN_QUEUE("/api/v1/queue/clean"),
  PATCH_QUEUE_OPTIONS("/api/v1/queue/options"),
  GET_MESSAGES("/api/v1/queue/:queue_name/messages"),
  GET_MESSAGE("/api/v1/queue/message"),
  GET_MESSAGE_POLL("/api/v1/queue/message/poll"),
  GET_MESSAGE_PEEK("/api/v1/queue/message/peek"),
  POST_MESSAGE("/api/v1/queue/message")
  ;

  final String url;
  RoutesURL(String url) {
    this.url = url;
  }
  @Override
  public String toString() {
    return url;
  }
  public String getURL() {
    return url;
  }
}
