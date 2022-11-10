package com.ah3nan.opensqs.resources;

import com.ah3nan.opensqs.api.rest.RoutesURL;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import com.ah3nan.opensqs.core.SQBucket;
import com.ah3nan.opensqs.core.queue.SQueue;

import java.util.UUID;

public class SQueueResource {
  private static final CharSequence RESPONSE_TYPE_JSON = HttpHeaders.createOptimized("application/json");

  public static void getQueues() {
    SQBucket sqBucket = SQBucket.getInstance();

  }
  public static void getQueue() {

    SQBucket sqBucket = SQBucket.getInstance();

  }
  public static void addQueue() {

    SQBucket sqBucket = SQBucket.getInstance();

  }
  public static void deleteQueue() {
    SQBucket sqBucket = SQBucket.getInstance();

  }
  public static void cleanQueue() {
    SQBucket sqBucket = SQBucket.getInstance();

  }

  public static void updateQueue() {
    SQBucket sqBucket = SQBucket.getInstance();

  }

  public static void updateQueueOptions() {
    SQBucket sqBucket = SQBucket.getInstance();

  }
}
