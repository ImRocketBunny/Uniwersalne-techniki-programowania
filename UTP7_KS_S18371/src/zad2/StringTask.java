package zad2;

public class StringTask implements Runnable {
    String str;
    int integ;
    public TaskState stanObecny;
    public String resultString;
    public Thread task;
    public volatile boolean powinnoDzialac;
    public StringTask(String str, int integ){
        this.str=str;
        this.integ=integ;
        this.task=new Thread(this);
        this.powinnoDzialac=false;
        this.stanObecny=TaskState.CREATED;
        this.resultString="";

    }
    public enum TaskState {
        CREATED,RUNNING,ABORTED,READY;
    }

    @Override
    public void run() {
        while(powinnoDzialac) {
            stanObecny=TaskState.RUNNING;
            int lpom=integ;
            String xd = "";
            for(int i = str.length()-1; i >=0;i--){
                xd+=str.charAt(i);
            }
            for(int i=0;i<lpom;i++) {
                resultString = resultString + xd;
                integ--;
            }
            if(integ==0) {
                stanObecny=TaskState.READY;
                powinnoDzialac=false;
            }
        }

    }


    public TaskState getState(){
        return stanObecny;
    }

    public String getResult() {
        return resultString;

    }
    public void abort() {
        task.interrupt();
        powinnoDzialac=false;
        stanObecny=TaskState.ABORTED;
    }

    public boolean isDone() {
        if(stanObecny.equals(TaskState.READY)||stanObecny.equals(TaskState.ABORTED)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void start() {
        task.start();
        powinnoDzialac=true;
    }
}
