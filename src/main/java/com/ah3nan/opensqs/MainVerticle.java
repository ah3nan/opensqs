package com.ah3nan.opensqs;

import io.vertx.core.*;

public class MainVerticle extends AbstractVerticle {


  public static void main(String[] args)  {
    VertxOptions personVertxOptions = new VertxOptions()
      .setDisableTCCL(true)
      .setHAEnabled(false)
      ;
    Vertx vertx = Vertx.vertx(personVertxOptions);
    vertx.deployVerticle(new MainVerticle());
  }


  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("Starting Main Verticle");

    DeploymentOptions personDeploymentOptions = new DeploymentOptions()
      .setInstances(Runtime.getRuntime().availableProcessors() - 2)

      ;

    vertx.deployVerticle(SQueueVerticle.class.getName(),personDeploymentOptions);
    startPromise.complete();
  }
}
