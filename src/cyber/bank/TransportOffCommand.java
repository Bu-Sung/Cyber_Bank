
package cyber.bank;

public class TransportOffCommand implements Command {
  private Transport mTransport;

  public TransportOffCommand(Transport transport) {
      mTransport = transport;
  }

  public void execute() {
      mTransport.off();
  }

}
