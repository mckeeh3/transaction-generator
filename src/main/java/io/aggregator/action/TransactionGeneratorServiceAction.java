package io.aggregator.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.aggregator.action.TransactionGeneratorAction.GenerateTransactionRequest;
import io.aggregator.action.TransactionGeneratorAction.TopicTransaction;
import io.aggregator.action.TransactionGeneratorAction.TopicTransactionKey;
import kalix.javasdk.action.ActionCreationContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your io/aggregator/action/generator_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class TransactionGeneratorServiceAction extends AbstractTransactionGeneratorServiceAction {
  private static final Logger log = LoggerFactory.getLogger(TransactionGeneratorServiceAction.class);

  public TransactionGeneratorServiceAction(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<TopicTransaction> generateTransaction(GenerateTransactionRequest request) {
    var topicTransaction = TopicTransaction
        .newBuilder()
        .setTransactionKey(
            TopicTransactionKey
                .newBuilder()
                .setTransactionId(request.getTransactionId())
                .setServiceCode("service-code-1")
                .setAccountFrom("account-from-2")
                .setAccountTo("account-to-3")
                .build())
        .setMerchantId(request.getMerchantId())
        .setTransactionAmount(request.getTransactionAmount())
        .setShopId(request.getMerchantId())
        .build();

    log.info("generateTransaction: {}", topicTransaction);

    var metadata = actionContext().metadata().set("ce-subject", request.getTransactionId());
    return effects()
        .reply(topicTransaction, metadata);
  }
}
