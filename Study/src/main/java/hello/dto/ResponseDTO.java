package hello.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseDTO {
    private static final ObjectMapper mapper = new ObjectMapper();
    private String returnCode;
    private Object returnValue;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public ResponseDTO(String returnCode, Object returnValue) {
        this.returnCode = returnCode;
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        String result;
        try {
            result = mapper.writeValueAsString(this);
        }catch (Exception e){

            result = null;
        }
        return result;
    }
}
