package SpringCloudGateway.responseMapper;

import java.util.Objects;

public class JsonResponse {

    private  boolean isok;
    private  int code;
    private  String message;
    private  Object data;

    private JsonResponse() {
    }

    public static JsonResponse responseAll() {
        JsonResponse resultBean = new JsonResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("responseAll");
        resultBean.setData("Data is Me");
        return resultBean;
    }

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "isok=" + isok +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponse that = (JsonResponse) o;
        return isok == that.isok && code == that.code && message.equals(that.message) && data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isok, code, message, data);
    }
}
