
package cyber.bank;

public class TransportOnCommand implements Command {
  private Transport mTransport;

  public TransportOnCommand(Transport transport) {
      mTransport = transport;
  }

  public void execute() {
      mTransport.on();
  }

}
