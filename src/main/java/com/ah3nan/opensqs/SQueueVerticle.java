package com.ah3nan.opensqs;
import io.vertx.core.*;
import io.vertx.core.logging.SLF4JLogDelegateFactory;

import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;

public class SQueueVerticle extends AbstractVerticle {


  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    setupLogger();

  }

  public void stop() throws Exception {
    super.stop();
    System.out.println("Stopping");
  }

  public void setupLogger() {
    String logFactory = System.getProperty("vertx.logger-delegate-factory-class-name");
    String logAsync = System.getProperty("log4j2.contextSelector");

    if (logFactory == null) {
      System.setProperty("vertx.logger-delegate-factory-class-name", SLF4JLogDelegateFactory.class.getName());
    }
    if (logAsync == null) {
      System.setProperty("log4j2.contextSelector", AsyncLoggerContextSelector.class.getName());
    }
  }
}
