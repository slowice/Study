package hello.util;

import javax.servlet.http.HttpServletRequest;

public class TestMain {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equals("XMLHttpRequest")) {
            return true;
        } else return "XMLHttpRequest".equals(request.getParameter("X-Requested-With"));
    }

    public static void main(String[] args) {

        String date = "";
        try {
            SSHUtil sshUtil=new SSHUtil();
            sshUtil.download("/pcccmall/logs/mcustomer-mcustomer.log.20180209","E://test");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
