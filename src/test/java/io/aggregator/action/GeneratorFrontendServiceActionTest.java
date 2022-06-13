package io.aggregator.action;

import akka.stream.javadsl.Source;
import io.aggregator.action.GeneratorFrontendAction;
import io.aggregator.action.GeneratorFrontendServiceAction;
import io.aggregator.action.GeneratorFrontendServiceActionTestKit;
import kalix.javasdk.testkit.ActionResult;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class GeneratorFrontendServiceActionTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    GeneratorFrontendServiceActionTestKit service = GeneratorFrontendServiceActionTestKit.of(GeneratorFrontendServiceAction::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void generateTransactionsTest() {
    GeneratorFrontendServiceActionTestKit testKit = GeneratorFrontendServiceActionTestKit.of(GeneratorFrontendServiceAction::new);
    // ActionResult<GeneratorFrontendAction.GenerateTransactionsResponse> result = testKit.generateTransactions(GeneratorFrontendAction.GenerateTransactionsRequest.newBuilder()...build());
  }

}
