package io.aggregator.action;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.Empty;

import io.aggregator.action.GeneratorFrontendAction.GenerateTransactionsRequest;
import io.aggregator.action.TransactionGeneratorAction.GenerateTransactionRequest;
import kalix.javasdk.action.ActionCreationContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your io/aggregator/action/generator_frontend_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class GeneratorFrontendServiceAction extends AbstractGeneratorFrontendServiceAction {
  private static final Logger log = LoggerFactory.getLogger(GeneratorFrontendServiceAction.class);

  public GeneratorFrontendServiceAction(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<Empty> generateTransactions(GenerateTransactionsRequest request) {
    var results = IntStream.rangeClosed(1, request.getTransactionCount())
        .mapToObj(i -> {
          return generateTransactionRequests(i, request);
        })
        .flatMap(x -> x)
        .map(command -> components().transactionGeneratorServiceAction().generateTransaction(command).execute())
        .toList();

    var result = CompletableFuture.allOf(results.toArray(new CompletableFuture[results.size()]))
        .thenApply(reply -> effects().reply(Empty.getDefaultInstance()));

    log.info("generateTransactions: processed {} transactions", results.size());

    return effects().asyncEffect(result);
  }

  private Stream<GenerateTransactionRequest> generateTransactionRequests(int transactionId, GenerateTransactionsRequest request) {
    return IntStream.rangeClosed(1, request.getMerchantCount())
        .mapToObj(merchantId -> {
          return GenerateTransactionRequest
              .newBuilder()
              .setTransactionId(String.format("transaction-%d-%s", transactionId, UUID.randomUUID()))
              .setMerchantId("merchant-" + merchantId)
              .setTransactionAmount(request.getTransactionAmount())
              .build();
        });
  }
}
