package io.aggregator.action;

import akka.stream.javadsl.Source;
import io.aggregator.action.TransactionGeneratorAction;
import io.aggregator.action.TransactionGeneratorServiceAction;
import io.aggregator.action.TransactionGeneratorServiceActionTestKit;
import kalix.javasdk.testkit.ActionResult;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class TransactionGeneratorServiceActionTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    TransactionGeneratorServiceActionTestKit service = TransactionGeneratorServiceActionTestKit.of(TransactionGeneratorServiceAction::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void generatrTransactionsTest() {
    TransactionGeneratorServiceActionTestKit testKit = TransactionGeneratorServiceActionTestKit.of(TransactionGeneratorServiceAction::new);
    // ActionResult<TransactionGeneratorAction.GenerateTransactionsResponse> result = testKit.generatrTransactions(TransactionGeneratorAction.GenerateTransactionsRequest.newBuilder()...build());
  }

}
