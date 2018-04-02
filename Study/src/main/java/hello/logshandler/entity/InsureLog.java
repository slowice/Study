package hello.logshandler.entity;


import java.io.Serializable;

public class InsureLog implements Serializable{
    private String mrchntTraceNo;
    private String orderId;
    private String paySend;
    private String payReceive;

    public String getMrchntTraceNo() {
        return mrchntTraceNo;
    }

    public void setMrchntTraceNo(String mrchntTraceNo) {
        this.mrchntTraceNo = mrchntTraceNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaySend() {
        return paySend;
    }

    public void setPaySend(String paySend) {
        this.paySend = paySend;
    }

    public String getPayReceive() {
        return payReceive;
    }

    public void setPayReceive(String payReceive) {
        this.payReceive = payReceive;
    }

    @Override
    public String toString() {
        return "InsureLog{" +
                "mrchntTraceNo='" + mrchntTraceNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", paySend='" + paySend + '\'' +
                ", payReceive='" + payReceive + '\'' +
                '}';
    }
}
