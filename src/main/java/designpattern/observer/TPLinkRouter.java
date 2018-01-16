package designpattern.observer;

public class TPLinkRouter implements Router {

	public void sendData(char[] data) {
		// TODO Auto-generated method stub

	}

	public void acceptData(char[] data) {
		// TODO Auto-generated method stub

	}

	public void accept(RouterVisitor v) {
		v.visit(this);
	}

}
