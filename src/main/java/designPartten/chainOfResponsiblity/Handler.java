package designPartten.chainOfResponsiblity;


import java.util.ArrayList;
import java.util.List;

public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}

class HandlerA extends Handler {
    @Override
    protected boolean doHandle() {
        System.out.println("A执行了");
        boolean handled = false;
        //...
        return handled;
    }
}

class HandlerChain {
    /*  private Handler head = null;
      private Handler tail = null;

      public void addHandler(Handler handler) {
          handler.setSuccessor(null);
          if (head == null) {
              head = handler;
              tail = handler;
              return;
          }
          tail.setSuccessor(handler);
          tail = handler;
      }

      public void handle() {
          if (head != null) {
              head.handle();
          }
      }*/
    List<Handler> list = new ArrayList<>();

    public void addHandler(Handler handler) {
        list.add(handler);
    }

    public void handler() {
        for (Handler handler : list) {
            handler.handle();
        }
    }
}

class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        System.out.println("B执行了");

        boolean handled = false;
        //...
        return handled;
    }
}


// HandlerChain和Application代码不变


